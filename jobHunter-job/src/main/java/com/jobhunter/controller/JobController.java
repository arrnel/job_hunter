package com.jobhunter.controller;

import com.jobhunter.dto.JobRequest;
import com.jobhunter.dto.JobResponse;
import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.StatusDTO;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface JobController {

    JobResponse createNewJob(Long companyId, JobRequest requestBody);

    JobResponse getJob(Long jobId);

    PageResponse getJobs(
            Long companyId
            , String partialTitle
            , String partialDescription
            , String partialContent
            , BigDecimal minPrice
            , BigDecimal maxPrice
            , String currency
            , Integer cityId
            , Integer regionId
            , Integer countryId
            , LocalDate afterDate
            , LocalDate beforeDate
            , Pageable pageable
    );

    JobResponse updateJob(Long jobId, JobRequest requestBody);

    StatusDTO deleteJob(Long jobId);

}
