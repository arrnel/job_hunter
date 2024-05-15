package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class JobAlreadyExistsInCompanyException extends GlobalException {

    public JobAlreadyExistsInCompanyException(ECode code) {
        super(code);
    }

    public JobAlreadyExistsInCompanyException(ECode code, String message) {
        super(code, message);
    }

}
