package com.jobhunter.service.impl;

import com.jobhunter.config.Config;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.requestParams.JobsFilter;
import com.jobhunter.exception.JobAlreadyExistsInCompanyException;
import com.jobhunter.exception.JobNotFoundException;
import com.jobhunter.mapper.JobUpdater;
import com.jobhunter.model.Job;
import com.jobhunter.repository.JobRepository;
import com.jobhunter.service.JobService;
import com.jobhunter.specification.JobSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static com.jobhunter.enums.ECode.JOB_NAME_IS_ALREADY_EXISTS_IN_COMPANY;
import static com.jobhunter.enums.ECode.JOB_NOT_FOUND;
import static com.jobhunter.helper.StringHelper.isNullOrBlank;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobUpdater jobUpdater;
    private final JobSpecification jobSpecification;

    @Override
    public Job createNewJob(Long companyId, Job newJob) {

        newJob.setCompanyId(companyId);
        boolean isJobExistInCompanyWithTitle = jobRepository.existsByCompanyIdAndTitle(companyId, newJob.getTitle());

        if (isJobExistInCompanyWithTitle) throw new JobAlreadyExistsInCompanyException(
                JOB_NAME_IS_ALREADY_EXISTS_IN_COMPANY,
                "Job with name is already exists in company");
        log.info("Job before save = {}", newJob);
        return jobRepository.save(newJob);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Job> getJob(Long jobId) {
        return jobRepository.findById(jobId);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Job> getJobs(JobsFilter requestParams, final Pageable pageable) {

        String currency = requestParams.getCurrency();
        BigDecimal rate = (isNullOrBlank(currency) || currency.equalsIgnoreCase(Config.Currency.defaultCurrency()))
                ? BigDecimal.ONE
                : BigDecimal.TWO;

        BigDecimal minPrice = Optional.ofNullable(requestParams.getMinPrice())
                .filter(price -> price.compareTo(BigDecimal.ZERO) > 0)
                .map(price -> price.multiply(rate))
                .orElse(null);
        requestParams.setMinPriceInDefaultCurrency(minPrice);

        BigDecimal maxPrice = Optional.ofNullable(requestParams.getMaxPrice())
                .filter(price -> price.compareTo(BigDecimal.ZERO) > 0)
                .map(price -> price.multiply(rate))
                .orElse(null);
        requestParams.setMaxPriceInDefaultCurrency(maxPrice);

        return jobRepository.findAll(jobSpecification.findByCriteria(requestParams), pageable);
    }

    @Override
    public Job updateJob(Long jobId, Job newJob) {

        String newJobTitle = newJob.getTitle();
        Job oldJob = jobRepository.findById(jobId)
                .orElseThrow(() -> new JobNotFoundException(JOB_NOT_FOUND, "Job with id = [" + jobId + "] not found"));
        boolean isJobExistInCompanyWithTitle =
                newJobTitle != null
                        && !oldJob.getTitle().equals(newJobTitle)
                        && jobRepository.existsByCompanyIdAndTitle(oldJob.getCompanyId(), newJob.getTitle());

        if (isJobExistInCompanyWithTitle)
            throw new JobAlreadyExistsInCompanyException(
                    JOB_NAME_IS_ALREADY_EXISTS_IN_COMPANY,
                    "Job with name is already exists in company");
        oldJob = jobUpdater.update(oldJob, newJob);
        log.info("Saving job: {}", oldJob.toString());
        return jobRepository.save(oldJob);

    }

    @Override
    public StatusDTO deleteJob(Long jobId) {
        jobRepository.delete(jobRepository
                .findById(jobId)
                .orElseThrow(() -> new JobNotFoundException(JOB_NOT_FOUND, "Job with id = [" + jobId + "] not found")));
        return new StatusDTO(true);
    }
}
