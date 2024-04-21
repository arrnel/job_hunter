package com.jobhunter.exception;

import com.jobHunter.enums.ECode;
import com.jobHunter.exception.GlobalException;

public class LocationNotFoundException extends GlobalException {

    public LocationNotFoundException(ECode code) {
        super(code);
    }

    public LocationNotFoundException(ECode code, String message) {
        super(code, message);
    }

}
