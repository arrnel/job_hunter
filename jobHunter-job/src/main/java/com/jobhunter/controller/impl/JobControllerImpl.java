package com.jobhunter.controller.impl;

import com.jobhunter.controller.JobController;
import com.jobhunter.dto.JobRequest;
import com.jobhunter.dto.JobResponse;
import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.requestParams.JobsFilter;
import com.jobhunter.exception.JobNotFoundException;
import com.jobhunter.mapper.JobRequestToJobMapper;
import com.jobhunter.mapper.JobToJobResponseMapper;
import com.jobhunter.mapper.PageToPageResponseMapper;
import com.jobhunter.service.JobService;
import com.jobhunter.validation.JobsFilterValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.jobhunter.enums.ECode.JOB_TYPE_NOT_FOUND;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class JobControllerImpl implements JobController {

    private final JobService jobService;
    private final JobRequestToJobMapper mapJobRequestToJob;
    private final JobToJobResponseMapper mapJobToJobResponse;
    private final PageToPageResponseMapper mapPageToPageResponse;
    private final JobsFilterValidation jobsFilterValidation;

    @Override
    @PostMapping("/company/{company_id}/job")
    @ResponseStatus(HttpStatus.CREATED)
    public JobResponse createNewJob(
            @PathVariable("company_id") Long companyId
            , @RequestBody JobRequest requestBody
    ) {

        log.info("Create new job in company with id = [{}] and request = \n [{}]", companyId, requestBody.toString());

        return mapJobToJobResponse.map(
                jobService.createNewJob(companyId,
                        mapJobRequestToJob
                                .map(requestBody)
                                .setDateCreated(LocalDateTime.now())
                ));
    }

    @Override
    @GetMapping("/job/{jobId}")
    @ResponseStatus(HttpStatus.OK)
    public JobResponse getJob(@PathVariable Long jobId) {
        log.info("Get job with id = [{}]", jobId);
        return mapJobToJobResponse.map(jobService.getJob(jobId)
                .orElseThrow(() -> new JobNotFoundException(JOB_TYPE_NOT_FOUND, "Job with id = [" + jobId + "] not found")));
    }

    @Override
    @GetMapping("/job")
    @ResponseStatus(HttpStatus.OK)
    public PageResponse getJobs(
            @RequestParam(required = false, name = "company_id") Long companyId
            , @RequestParam(required = false, name = "partial_title") String partialTitle
            , @RequestParam(required = false, name = "partial_description") String partialDescription
            , @RequestParam(required = false, name = "partial_content") String partialContent
            , @RequestParam(required = false, name = "min_price") BigDecimal minPrice
            , @RequestParam(required = false, name = "max_price") BigDecimal maxPrice
            , @RequestParam(required = false, name = "currency") String currency
            , @RequestParam(required = false, name = "city_id") Integer cityId
            , @RequestParam(required = false, name = "region_id") Integer regionId
            , @RequestParam(required = false, name = "country_id") Integer countryId
            , @RequestParam(required = false, name = "after_date") LocalDate afterDate
            , @RequestParam(required = false, name = "before_date") LocalDate beforeDate
            , Pageable pageable
    ) {

        JobsFilter requestParams = JobsFilter.builder()
                .companyId(companyId)
                .partialTitle(partialTitle)
                .partialDescription(partialDescription)
                .partialContent(partialContent)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .currency(currency)
                .cityId(cityId)
                .regionId(regionId)
                .countryId(countryId)
                .afterDate(afterDate)
                .beforeDate(beforeDate)
                .build();

        log.info("Get jobs with request params: [{}] in page = [{}] and per page = [{}]"
                , requestParams.toString()
                , pageable.getPageNumber()
                , pageable.getPageSize()
        );

        jobsFilterValidation.validate(requestParams);

        return mapPageToPageResponse.map(jobService.getJobs(requestParams, pageable));

    }

    @Override
    @PutMapping("/job/{jobId}")
    @ResponseStatus(HttpStatus.OK)
    public JobResponse updateJob(@PathVariable Long jobId, @RequestBody JobRequest requestBody) {
        log.info("Update job with id = [{}] and request = \n [{}]", jobId, requestBody.toString());
        return mapJobToJobResponse.map(
                jobService.updateJob(
                        jobId,
                        mapJobRequestToJob.map(requestBody)
                ));
    }

    @Override
    @DeleteMapping("/job/{jobId}")
    @ResponseStatus(HttpStatus.OK)
    public StatusDTO deleteJob(@PathVariable Long jobId) {
        log.info("Remove job with id = [{}]", jobId);
        jobService.deleteJob(jobId);
        return new StatusDTO(true);
    }

}
