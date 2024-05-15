package com.jobhunter.controller;

import com.jobhunter.model.CurrencyRateDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CurrencyController {

    CurrencyRateDTO getRate(@RequestParam("from") String fromValue, @RequestParam("to") String toValue);

    List<CurrencyRateDTO> getAllCurrencies();

    void update();

}
