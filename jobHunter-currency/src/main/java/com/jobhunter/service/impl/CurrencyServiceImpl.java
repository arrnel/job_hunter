package com.jobhunter.service.impl;

import com.jobhunter.dataParser.CurrencyUpdater;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.exception.CurrencyNotFoundException;
import com.jobhunter.model.Currency;
import com.jobhunter.model.CurrencyEntity;
import com.jobhunter.model.CurrencyRateDTO;
import com.jobhunter.repository.CurrencyRepository;
import com.jobhunter.service.CurrencyService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.jobhunter.enums.ECode.CURRENCY_NOT_FOUND;
import static java.math.RoundingMode.CEILING;

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

        CurrencyEntity fromEntity = currencyRepository.findByCurrency(from).orElseThrow(() -> new CurrencyNotFoundException(
                CURRENCY_NOT_FOUND
                , "Currency \"from\" = [" + from + "] not found"));
        CurrencyEntity toEntity = currencyRepository.findByCurrency(to).orElseThrow(() -> new CurrencyNotFoundException(
                CURRENCY_NOT_FOUND
                , "Currency \"to\" = [" + to + "] not found"));

        return CurrencyRateDTO.builder()
                .from(from)
                .to(to)
                .rate(calculateRate(fromEntity.getRate(), toEntity.getRate()))
                .dateUpdated(fromEntity.getDateUpdated())
                .build();

    }

    private static BigDecimal calculateRate(BigDecimal from, BigDecimal to) {
        return BigDecimal.ONE.divide(from, 6, CEILING).multiply(to).setScale(6, CEILING);
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
                                .dateUpdated(value.getDateUpdated())
                                .build()
                ).toList();

    }


}
