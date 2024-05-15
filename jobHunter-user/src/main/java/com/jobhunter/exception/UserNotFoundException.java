package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class UserNotFoundException extends GlobalException{

    public UserNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public UserNotFoundException(ECode code) {
        super(code);
    }

}
