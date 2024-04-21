package com.jobhunter.service.impl;

import com.jobhunter.dataParser.CurrencyUpdater;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.exception.CurrencyNotFoundException;
import com.jobhunter.model.Currency;
import com.jobhunter.model.CurrencyRateDTO;
import com.jobhunter.repository.CurrencyRepository;
import com.jobhunter.service.CurrencyService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import static com.jobhunter.enums.ECode.CURRENCY_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyUpdater currencyUpdater;

    private static LocalDateTime dateUpdated;

    @Override
    @PostConstruct
    public void init() {

        log.info("Checking cities table for update.");
        if (currencyRepository.count() == 0) {
            log.info("Table city is empty. Starting to update locations");
            update();

        }

    }

    @Override
    @Transactional(readOnly = true)
    public CurrencyRateDTO getRate(Currency from, Currency to) {

        log.info("Get exchange rate from = [{}], to = [{}]", from, to);



        return CurrencyRateDTO.builder()
                .from(from)
                .to(to)
                .dateUpdated(dateUpdated)
                .rate(
                        calculateRate(
                                currencyRepository.findByCurrency(from).orElseThrow(() -> new CurrencyNotFoundException(
                                                CURRENCY_NOT_FOUND
                                                , "Currency \"from\" = [" + from + "] not found"))
                                        .getRate()
                                , currencyRepository.findByCurrency(to).orElseThrow(() -> new CurrencyNotFoundException(
                                                CURRENCY_NOT_FOUND
                                                , "Currency \"to\" = [" + to + "] not found"))
                                        .getRate()
                        )
                )
                .build();

    }

    private static BigDecimal calculateRate(BigDecimal from, BigDecimal to) {
        return from.multiply(BigDecimal.valueOf(1).divide(to, 6, RoundingMode.CEILING));
    }

    @Override
    public StatusDTO update() {

        log.info("Updating currencies exchange rates");
        currencyUpdater.update();
        log.info("Currency rates updated successfully");
        return StatusDTO.builder().status(true).build();

    }

    @Override
    @Transactional(readOnly = true)
    public List<CurrencyRateDTO> getAllRates() {

        log.info("Get all currencies");
        return currencyRepository.findAll().stream()
                .map(value ->
                        CurrencyRateDTO.builder()
                                .from(Currency.getDefaultCurrency())
                                .to(value.getCurrency())
                                .rate(value.getRate())
                                .dateUpdated(dateUpdated)
                                .build()
                ).toList();

    }


}
