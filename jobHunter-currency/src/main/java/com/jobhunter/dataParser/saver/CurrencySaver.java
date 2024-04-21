package com.jobhunter.dataParser.saver;


import com.jobhunter.model.Currency;

import java.math.BigDecimal;
import java.util.Map;

public interface CurrencySaver {

    public void save(Map<Currency, BigDecimal> currencies);

}
