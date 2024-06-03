package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class CompanyAlreadyExistsException extends GlobalException {

    public CompanyAlreadyExistsException(ECode code) {
        super(code);
    }

    public CompanyAlreadyExistsException(ECode code, String message) {
        super(code, message);
    }

}
