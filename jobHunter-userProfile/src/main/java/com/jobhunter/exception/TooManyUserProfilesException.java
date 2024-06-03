package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class TooManyUserProfilesException extends GlobalException {

    public TooManyUserProfilesException() {
        super(ECode.EXCEEDED_THE_COURSE_LIMIT);
    }

    public TooManyUserProfilesException(ECode code) {
        super(code);
    }

    public TooManyUserProfilesException(ECode code, String message) {
        super(code, message);
    }

    public TooManyUserProfilesException(String message){
        super(ECode.EXCEEDED_THE_COURSE_LIMIT, message);
    }

    public TooManyUserProfilesException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public TooManyUserProfilesException(String message, HttpStatus status) {
        super(ECode.EXCEEDED_THE_COURSE_LIMIT, message, status.value());
    }

}
