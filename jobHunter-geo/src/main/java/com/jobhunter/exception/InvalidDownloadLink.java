package com.jobhunter.exception;

import com.jobHunter.enums.ECode;
import com.jobHunter.exception.GlobalException;

public class InvalidDownloadLink extends GlobalException {

    public InvalidDownloadLink(ECode code) {
        super(code);
    }

    public InvalidDownloadLink(ECode code, String message) {
        super(code, message);
    }

}
