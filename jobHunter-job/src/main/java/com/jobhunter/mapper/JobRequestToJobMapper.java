package com.jobhunter.mapper;

import com.jobhunter.dto.JobRequest;
import com.jobhunter.model.Job;

public interface JobRequestToJobMapper extends Mapper<Job, JobRequest> {
    Job map(JobRequest source);
}
