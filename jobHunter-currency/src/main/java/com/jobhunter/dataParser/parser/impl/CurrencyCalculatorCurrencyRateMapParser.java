package com.jobhunter.dataParser.parser.impl;

import com.jobhunter.dataParser.parser.CurrencyRateMapParser;
import com.jobhunter.model.Currency;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CurrencyCalculatorCurrencyRateMapParser implements CurrencyRateMapParser {

    @Override
    public Map<Currency, BigDecimal> parse(String text) {

        Map<Currency, BigDecimal> map = new TreeMap<>();
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
