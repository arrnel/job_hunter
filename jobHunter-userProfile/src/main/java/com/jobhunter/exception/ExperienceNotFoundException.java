package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class ExperienceNotFoundException extends GlobalException {

    public ExperienceNotFoundException(ECode code) {
        super(code);
    }

    public ExperienceNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public ExperienceNotFoundException(String message){
        super(ECode.EXPERIENCE_NOT_FOUND, message);
    }

    public ExperienceNotFoundException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public ExperienceNotFoundException(String message, HttpStatus status) {
        super(ECode.EXPERIENCE_NOT_FOUND, message, status.value());
    }

}
