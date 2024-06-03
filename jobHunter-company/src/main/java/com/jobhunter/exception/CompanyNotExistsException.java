package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class CompanyNotExistsException extends GlobalException {

    public CompanyNotExistsException(ECode code) {
        super(code);
    }

    public CompanyNotExistsException(ECode code, String message) {
        super(code, message);
    }

    public CompanyNotExistsException(String message){
        super(ECode.COMPANY_NOT_FOUND, message);
    }

    public CompanyNotExistsException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

}
