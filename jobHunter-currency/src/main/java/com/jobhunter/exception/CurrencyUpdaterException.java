package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class CurrencyUpdaterException extends GlobalException {

    public CurrencyUpdaterException(ECode code, String message) {
        super(code, message);
    }

    public CurrencyUpdaterException(ECode code) {
        super(code);
    }

    public CurrencyUpdaterException(String message) {
        super(ECode.CURRENCY_INFO_DOWNLOAD_FAIL, message);
    }

    public CurrencyUpdaterException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public CurrencyUpdaterException(String message, HttpStatus status) {
        super(ECode.CURRENCY_INFO_DOWNLOAD_FAIL, message, status.value());
    }

}
