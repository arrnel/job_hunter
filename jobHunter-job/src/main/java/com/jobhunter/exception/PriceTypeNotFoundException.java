package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class PriceTypeNotFoundException extends GlobalException {

    public PriceTypeNotFoundException(ECode code) {
        super(code);
    }

    public PriceTypeNotFoundException(ECode code, String message) {
        super(code, message);
    }

}
