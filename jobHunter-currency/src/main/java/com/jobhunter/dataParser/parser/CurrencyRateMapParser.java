package com.jobhunter.dataParser.parser;

import com.jobhunter.model.Currency;

import java.math.BigDecimal;
import java.util.Map;

public interface CurrencyRateMapParser {

    Map<Currency, BigDecimal> parse(String source);

}
