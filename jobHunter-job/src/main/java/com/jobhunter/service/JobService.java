package com.jobhunter.service;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.requestParams.JobsFilter;
import com.jobhunter.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface JobService {

    Job createNewJob(Long companyId, Job requestBody);

    Optional<Job> getJob(Long jobId);

    Page<Job> getJobs(JobsFilter requestParams, Pageable pageable);

    Job updateJob(Long jobId, Job requestBody);

    StatusDTO deleteJob(Long jobId);

}
