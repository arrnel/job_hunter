package com.jobhunter.dataParser.extractor.impl;

import com.jobhunter.dataParser.extractor.CurrencyInfoExtractor;
import com.jobhunter.model.Currency;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyCalculatorCurrencyInfoExtractor implements CurrencyInfoExtractor {

    @Override
    public Map<Currency, BigDecimal> convert(String text) {

        Map<Currency, BigDecimal> map = new HashMap<>();
        List<Currency> currenciesList = new LinkedList<>(Arrays.asList(Currency.values()));

        Pattern pattern = Pattern.compile("\\[\"(\\w{3})\",(\\d+\\.?\\d*)]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String currencyName = matcher.group(1);
            BigDecimal rate = new BigDecimal(matcher.group(2));

            for (Currency currency : currenciesList) {
                if (currencyName.equals(currency.name())) {
                    map.put(currency, rate);
                    currenciesList.remove(currency);
                    break;
                }
            }
        }

        return map;

    }
}
