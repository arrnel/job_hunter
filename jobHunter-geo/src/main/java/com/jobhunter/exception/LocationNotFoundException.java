package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class LocationNotFoundException extends GlobalException {

    public LocationNotFoundException(ECode code) {
        super(code);
    }

    public LocationNotFoundException(ECode code, String message) {
        super(code, message);
    }

}
