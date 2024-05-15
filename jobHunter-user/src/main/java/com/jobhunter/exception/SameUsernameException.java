package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class SameUsernameException extends GlobalException{

    public SameUsernameException(ECode code, String message) {
        super(code, message);
    }

    public SameUsernameException(ECode code) {
        super(code);
    }

}
