package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class CompanyEmailOrNameIsAlreadyTakenException extends GlobalException {

    public CompanyEmailOrNameIsAlreadyTakenException(ECode code) {
        super(code);
    }

    public CompanyEmailOrNameIsAlreadyTakenException(ECode code, String message) {
        super(code, message);
    }

    public CompanyEmailOrNameIsAlreadyTakenException(String message) {
        super(ECode.COMPANY_EMAIL_OR_NAME_IS_ALREADY_TAKEN, message);
    }

    public CompanyEmailOrNameIsAlreadyTakenException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

}
