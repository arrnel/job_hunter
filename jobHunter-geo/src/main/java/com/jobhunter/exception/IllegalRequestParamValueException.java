package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class IllegalRequestParamValueException extends GlobalException {

    public IllegalRequestParamValueException(ECode code) {
        super(code);
    }

    public IllegalRequestParamValueException(ECode code, String message) {
        super(code, message);
    }

}
