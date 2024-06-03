package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class InvalidExternalLinkException extends GlobalException {

    public InvalidExternalLinkException(ECode code) {
        super(code);
    }

    public InvalidExternalLinkException(ECode code, String message) {
        super(code, message);
    }

    public InvalidExternalLinkException(String message){
        super(ECode.INVALID_EXTERNAL_LINK, message);
    }

    public InvalidExternalLinkException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public InvalidExternalLinkException(String message, HttpStatus status) {
        super(ECode.INVALID_EXTERNAL_LINK, message, status.value());
    }

}
