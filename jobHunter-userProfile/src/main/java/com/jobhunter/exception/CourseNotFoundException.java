package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class EducationNotFoundException extends GlobalException {

    public EducationNotFoundException(ECode code) {
        super(code);
    }

    public EducationNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public EducationNotFoundException(String message){
        super(ECode.USER_PROFILE_NOT_FOUND, message);
    }

    public EducationNotFoundException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public EducationNotFoundException(String message, HttpStatus status) {
        super(ECode.USER_PROFILE_NOT_FOUND, message, status.value());
    }

}
