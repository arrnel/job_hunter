package com.jobhunter.service.impl;

import com.jobhunter.enums.JobType;
import com.jobhunter.model.JobTypeEntity;
import com.jobhunter.repository.JobTypeRepository;
import com.jobhunter.service.JobTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobTypeServiceImpl implements JobTypeService {

    private final JobTypeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<JobTypeEntity> getJobTypeByName(JobType name) {
        return repository.getByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<JobTypeEntity> getJobTypesByNames(Set<JobType> names) {
        return repository.getByNameIn(names);
    }

}
