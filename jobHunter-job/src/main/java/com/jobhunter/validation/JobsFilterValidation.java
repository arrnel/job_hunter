package com.jobhunter.validation;

import com.jobhunter.dto.requestParams.JobsFilter;

public interface JobsFilterValidation {
    void validate(JobsFilter requestParams);
}
