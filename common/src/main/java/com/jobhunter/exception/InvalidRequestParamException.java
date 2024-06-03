package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class InvalidRequestParamException extends GlobalException {

    public InvalidRequestParamException(ECode code) {
        super(code);
    }

    public InvalidRequestParamException(ECode code, String message) {
        super(code, message);
    }

    public InvalidRequestParamException(String message){
        super(ECode.INVALID_REQUEST_PARAM, message);
    }

    public InvalidRequestParamException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public InvalidRequestParamException(String message, HttpStatus status) {
        super(ECode.INVALID_REQUEST_PARAM, message, status.value());
    }

}
