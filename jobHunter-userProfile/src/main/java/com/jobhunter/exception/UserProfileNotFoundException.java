package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class UserProfileNotFoundException extends GlobalException {

    public UserProfileNotFoundException(ECode code) {
        super(code);
    }

    public UserProfileNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public UserProfileNotFoundException(String message) {
        super(ECode.USER_PROFILE_NOT_FOUND, message);
    }

    public UserProfileNotFoundException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public UserProfileNotFoundException(String message, HttpStatus status) {
        super(ECode.USER_PROFILE_NOT_FOUND, message, status.value());
    }

}
