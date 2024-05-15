package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class JobNotFoundException extends GlobalException {

    public JobNotFoundException(ECode code) {
        super(code);
    }

    public JobNotFoundException(ECode code, String message) {
        super(code, message);
    }

}
