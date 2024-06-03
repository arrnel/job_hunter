package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class TooManyEducationsException extends GlobalException {

    public TooManyEducationsException(ECode code) {
        super(code);
    }

    public TooManyEducationsException(ECode code, String message) {
        super(code, message);
    }

    public TooManyEducationsException(String message){
        super(ECode.EXCEEDED_THE_COURSE_LIMIT, message);
    }

    public TooManyEducationsException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public TooManyEducationsException(String message, HttpStatus status) {
        super(ECode.EXCEEDED_THE_COURSE_LIMIT, message, status.value());
    }

}
