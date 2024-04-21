package com.jobhunter.exception;

import com.jobHunter.enums.ECode;
import com.jobHunter.exception.GlobalException;

public class IllegalRequestParamValueException extends GlobalException {

    public IllegalRequestParamValueException(ECode code) {
        super(code);
    }

    public IllegalRequestParamValueException(ECode code, String message) {
        super(code, message);
    }

}
