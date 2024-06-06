package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class TooManyExperiencesException extends GlobalException {

    public TooManyExperiencesException() {
        super(ECode.EXCEEDED_THE_EXPERIENCE_LIMIT);
    }

    public TooManyExperiencesException(ECode code) {
        super(code);
    }

    public TooManyExperiencesException(ECode code, String message) {
        super(code, message);
    }

    public TooManyExperiencesException(String message) {
        super(ECode.EXCEEDED_THE_EXPERIENCE_LIMIT, message);
    }

    public TooManyExperiencesException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public TooManyExperiencesException(String message, HttpStatus status) {
        super(ECode.EXCEEDED_THE_EXPERIENCE_LIMIT, message, status.value());
    }

}
