package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class InvalidDownloadLink extends GlobalException {

    public InvalidDownloadLink(ECode code) {
        super(code);
    }

    public InvalidDownloadLink(ECode code, String message) {
        super(code, message);
    }

}
