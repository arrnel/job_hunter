package com.jobhunter.mapper;

import com.jobhunter.dto.JobResponse;
import com.jobhunter.model.Job;

public interface JobToJobResponseMapper extends Mapper<JobResponse, Job>{
    JobResponse map(Job source);
}
