package com.jobhunter.service;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.model.Currency;
import com.jobhunter.model.CurrencyRateDTO;

import java.util.List;

public interface CurrencyService {

    void init();

    CurrencyRateDTO getRate(Currency from, Currency to);

    List<CurrencyRateDTO> getAllRates();

    StatusDTO update();

}
