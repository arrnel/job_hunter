package com.jobhunter.dataParser;

import com.jobhunter.dataParser.downloader.CurrencyInfoDownloader;
import com.jobhunter.dataParser.parser.CurrencyRateMapParser;
import com.jobhunter.dataParser.saver.CurrencySaver;
import com.jobhunter.model.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyCalculator implements CurrencyUpdater {

    private final CurrencyInfoDownloader currencyInfoDownloader;
    private final CurrencyRateMapParser currencyInfoExtractor;
    private final CurrencySaver currencySaver;


    @Override
    public void update() {

        log.info("Start parsing currencies from external resource: https://www.calculator.net/currency-calculator.html");


        log.info("Start downloading html and parse currencies map text");
        String text = currencyInfoDownloader.getCurrenciesText();
        log.info("Successfully get html and parse currencies map text: {}", text);

        log.info("Start converting text map to Map <Currency, BigDecimal>");
        Map<Currency, BigDecimal> currencyMap = currencyInfoExtractor.parse(text);
        log.info("Successfully convert text map to Map <Currency, BigDecimal>: {}", currencyMap.toString());

        log.info("Start saving currencies into DB");
        currencySaver.save(currencyMap);
        log.info("Successfully saved currencies into DB");

    }

}
