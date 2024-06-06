package com.jobhunter.service;

import com.jobhunter.enums.JobType;
import com.jobhunter.model.JobTypeEntity;

import java.util.Optional;
import java.util.Set;

public interface JobTypeService {

    Optional<JobTypeEntity> getJobTypeByName(JobType name);

    Set<JobTypeEntity> getJobTypesByNames(Set<JobType> names);

}
