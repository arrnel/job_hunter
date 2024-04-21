package com.jobhunter.dataParser.extractor;

import com.jobhunter.model.Currency;

import java.math.BigDecimal;
import java.util.Map;

public interface CurrencyInfoExtractor {

    Map<Currency, BigDecimal> convert(String source);

}
