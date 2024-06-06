package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class CompanyAlreadyExistsException extends GlobalException {

    public CompanyAlreadyExistsException(ECode code) {
        super(code);
    }

    public CompanyAlreadyExistsException(ECode code, String message) {
        super(code, message);
    }

    public CompanyAlreadyExistsException(String message) {
        super(ECode.COMPANY_IS_ALREADY_EXISTS, message);
    }

    public CompanyAlreadyExistsException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

}
