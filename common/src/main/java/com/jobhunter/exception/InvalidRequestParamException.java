package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class InvalidRequestParamException extends GlobalException {

    public InvalidRequestParamException(ECode code) {
        super(code);
    }

    public InvalidRequestParamException(ECode code, String message) {
        super(code, message);
    }

}
