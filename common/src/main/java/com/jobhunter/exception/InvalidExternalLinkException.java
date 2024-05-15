package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class InvalidExternalLinkException extends GlobalException {

    public InvalidExternalLinkException(ECode code) {
        super(code);
    }

    public InvalidExternalLinkException(ECode code, String message) {
        super(code, message);
    }

}
