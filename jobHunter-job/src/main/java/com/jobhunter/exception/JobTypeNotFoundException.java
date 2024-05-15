package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class JobTypeNotFoundException extends GlobalException {

    public JobTypeNotFoundException(ECode code) {
        super(code);
    }

    public JobTypeNotFoundException(ECode code, String message) {
        super(code, message);
    }

}
