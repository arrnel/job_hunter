package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class CurrencyNotFoundException extends GlobalException{

    public CurrencyNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public CurrencyNotFoundException(ECode code) {
        super(code);
    }
}
