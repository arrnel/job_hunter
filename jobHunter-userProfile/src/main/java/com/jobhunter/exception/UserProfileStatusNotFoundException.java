package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class UserProfileStatusNotFoundException extends GlobalException {

    public UserProfileStatusNotFoundException(ECode code) {
        super(code);
    }

    public UserProfileStatusNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public UserProfileStatusNotFoundException(String message) {
        super(ECode.USER_PROFILE_NOT_FOUND, message);
    }

    public UserProfileStatusNotFoundException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public UserProfileStatusNotFoundException(String message, HttpStatus status) {
        super(ECode.USER_PROFILE_NOT_FOUND, message, status.value());
    }

}
