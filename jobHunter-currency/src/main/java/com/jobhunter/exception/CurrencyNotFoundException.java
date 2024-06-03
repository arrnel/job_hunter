package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class CurrencyNotFoundException extends GlobalException{

    public CurrencyNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public CurrencyNotFoundException(ECode code) {
        super(code);
    }

    public CurrencyNotFoundException(String message){
        super(ECode.CURRENCY_NOT_FOUND, message);
    }

    public CurrencyNotFoundException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public CurrencyNotFoundException(String message, HttpStatus status) {
        super(ECode.CURRENCY_NOT_FOUND, message, status.value());
    }

}
