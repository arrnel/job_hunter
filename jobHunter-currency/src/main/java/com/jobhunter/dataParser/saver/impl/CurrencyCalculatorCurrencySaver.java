package com.jobhunter.dataParser.saver.impl;

import com.jobhunter.dataParser.saver.CurrencySaver;
import com.jobhunter.model.Currency;
import com.jobhunter.model.CurrencyEntity;
import com.jobhunter.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyCalculatorCurrencySaver implements CurrencySaver {

    private final CurrencyRepository currencyRepository;
    private final Currency[] currencies = Currency.values();

    @Override
    public void save(Map<Currency, BigDecimal> currencyRateMap) {

        List<CurrencyEntity> currenciesList = currencyRepository.findAll();

        if (currenciesList.isEmpty()) {
            addNewEntities(currencyRateMap);
            log.info("Currencies table is empty. Add new currencies in db");
        } else {
            updateExistingEntities(currenciesList, currencyRateMap);
            log.info("Currencies table contains values. Updating currency rate values in db");
        }

    }

    private void updateExistingEntities(List<CurrencyEntity> savedCurrencies, Map<Currency, BigDecimal> currencyRateMap) {

        LocalDateTime now = LocalDateTime.now();

        savedCurrencies.forEach(
                currencyEntity -> currencyEntity
                        .setRate(currencyRateMap.get(currencyEntity.getCurrency()))
                        .setIsActive(Currency.isCurrencyActive(currencyEntity.getCurrency()))
                        .setDateUpdated(now)
        );

        currencyRepository.saveAll(savedCurrencies);

    }

    private void addNewEntities(Map<Currency, BigDecimal> currencyRateMap) {

        LocalDateTime now = LocalDateTime.now();

        currencyRepository.saveAll(
                Arrays.stream(currencies)
                        .map(currency -> CurrencyEntity.builder()
                                .currency(currency)
                                .rate(currencyRateMap.get(currency))
                                .isDefault(currency == Currency.getDefaultCurrency())
                                .isActive(Currency.isCurrencyActive(currency))
                                .dateUpdated(now)
                                .build())
                        .toList()
        );

    }
}
