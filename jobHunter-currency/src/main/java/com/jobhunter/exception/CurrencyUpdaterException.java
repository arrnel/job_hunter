package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class CurrencyUpdaterException extends GlobalException{

    public CurrencyUpdaterException(ECode code, String message) {
        super(code, message);
    }

    public CurrencyUpdaterException(ECode code) {
        super(code);
    }

}
