package com.jobhunter.mapper.impl;

import com.jobhunter.enums.ECode;
import com.jobhunter.enums.JobType;
import com.jobhunter.exception.JobNotFoundException;
import com.jobhunter.helper.EnumHelper;
import com.jobhunter.mapper.JobTypesToJobTypesEntityMapper;
import com.jobhunter.model.JobTypeEntity;
import com.jobhunter.repository.JobTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JobTypesToJobTypesEntityMapperImpl implements JobTypesToJobTypesEntityMapper {

    private final JobTypeRepository jobTypeRepository;

    @Override
    public Set<JobTypeEntity> map(Set<String> source) {

        return source.stream().map(jobTypeName -> jobTypeRepository
                        .getByName(EnumHelper.getEnumByNameIgnoreCase(JobType.class, jobTypeName))
                        .orElseThrow(() -> new JobNotFoundException(ECode.JOB_TYPE_NOT_FOUND)))
                .collect(Collectors.toSet());

    }

}
