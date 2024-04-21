package com.jobhunter.dataParser.downloader.impl;

import com.jobhunter.dataParser.downloader.CurrencyInfoDownloader;
import com.jobhunter.enums.ECode;
import com.jobhunter.exception.CurrencyUpdaterException;
import com.jobhunter.model.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.jobhunter.model.Currency.EUR;
import static com.jobhunter.model.Currency.USD;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyCalculatorCurrencyInfoDownloader implements CurrencyInfoDownloader {

    private static final String baseUrl = "https://www.calculator.net/currency-calculator.html";

    @Override
    public String getCurrenciesText() {
        return parseCurrenciesListText(getHtml());
    }

    private String getHtml() {

        RestTemplate restTemplate = new RestTemplate();
        String defaultCurrencyName = Currency.getDefaultCurrency().name(),
                anotherCurrencyName = (Currency.getDefaultCurrency() == USD) ? EUR.name() : USD.name();

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("eamount", "1");
        queryParams.put("efrom", defaultCurrencyName);
        queryParams.put("eto", anotherCurrencyName);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<?> result = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class, queryParams);

        if (result.getStatusCode().is2xxSuccessful()) {
            log.info("Successfully downloaded currency calculator html code");
        } else {
            throw new CurrencyUpdaterException(
                    ECode.CURRENCY_INFO_DOWNLOAD_FAIL
                    , "Incorrect status code in response when downloading information from www.calculator.net"
            );
        }

        return (String) result.getBody();

    }

    private String parseCurrenciesListText(String data) {

        var varName = "listsArrayData = ";

        if (!data.contains(varName)) throw new CurrencyUpdaterException(
                ECode.CURRENCY_INFO_DOWNLOAD_FAIL
                , "HTML from www.calculator.net should contains variable listsArrayData"
        );

        data = data.substring(data.indexOf(varName) + varName.length());
        return data.substring(0, data.indexOf(";"));
    }


}
