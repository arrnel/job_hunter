package com.jobhunter.service.external;

import com.jobhunter.dto.currency.CurrencyResponse;

public interface CurrencyService {

    CurrencyResponse getRate(String from, String to);

}
