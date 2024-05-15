package com.jobhunter.controller.impl;

import com.jobhunter.controller.CurrencyController;
import com.jobhunter.enums.ECode;
import com.jobhunter.exception.CurrencyNotFoundException;
import com.jobhunter.model.Currency;
import com.jobhunter.model.CurrencyRateDTO;
import com.jobhunter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/currency")
@RequiredArgsConstructor
public class CurrencyControllerImpl implements CurrencyController {

    private final CurrencyService currencyService;

    @Override
    @GetMapping
    @ResponseStatus(OK)
    public CurrencyRateDTO getRate(
            @RequestParam("from") String fromValue
            , @RequestParam("to") String toValue
    ) {

        Currency from = Currency.getCurrencyByName(fromValue),
                to = Currency.getCurrencyByName(toValue);

        if (from == null || to == null) {

            String errorMessage;

            if (from == null && to == null) {
                errorMessage = String.format("Invalid currencies from = [%s], to = [%s].", fromValue, toValue);
            } else if (from == null) {
                errorMessage = String.format("Invalid currency [from] = [%s].", fromValue);
            } else {
                errorMessage = String.format("Invalid currency [to] = [%s].", toValue);
            }
            throw new CurrencyNotFoundException(ECode.CURRENCY_NOT_FOUND, errorMessage);

        }

        return currencyService.getRate(from, to);

    }

    @GetMapping("/all")
    public List<CurrencyRateDTO> getAllCurrencies() {
        return currencyService.getAllRates();
    }

    @GetMapping("/update")
    public void update() {
        currencyService.update();
    }

    @Scheduled(fixedDelay = 60 * 60 * 1000) // INFO: updating every hour
    private void updateScheduled(){
        log.info("Start scheduled updating currencies");
        update();
    }


}
