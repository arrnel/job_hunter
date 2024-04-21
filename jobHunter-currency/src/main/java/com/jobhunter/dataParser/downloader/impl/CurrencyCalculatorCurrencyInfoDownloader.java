package com.jobhunter.dataParser.downloader.impl;

import com.jobhunter.dataParser.downloader.CurrencyInfoParser;
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
public class CurrencyCalculatorHtmlDownloader implements CurrencyInfoParser {

    @Override
    public String getCurrenciesText() {
        String html = getHtml();
        return parseCurrenciesListText(html);
    }

    private String getHtml() {

        RestTemplate restTemplate = new RestTemplate();
        String baseURL = "https://www.calculator.net/currency-calculator.html";
        String defaultCurrencyName = Currency.defaultCurrency.name(),
                anotherCurrencyName = (Currency.defaultCurrency == USD) ? EUR.name() : USD.name();

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("eamount", "1");
        queryParams.put("efrom", defaultCurrencyName);
        queryParams.put("eto", anotherCurrencyName);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<?> result = restTemplate.exchange(baseURL, HttpMethod.GET, entity, String.class, queryParams);

        return (String) result.getBody();

    }

    private String parseCurrenciesListText(String data) {
        var varText = "listsArrayData = ";
        data = data.substring(data.indexOf(varText) + varText.length());
        return data.substring(0, data.indexOf(";"));
    }


}
