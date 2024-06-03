package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class CompanyNameOrEmailIsAlreadyTakenException extends GlobalException {

    public CompanyNameOrEmailIsAlreadyTakenException(ECode code) {
        super(code);
    }

    public CompanyNameOrEmailIsAlreadyTakenException(ECode code, String message) {
        super(code, message);
    }

}
