package com.jobhunter.mapper;

import com.jobhunter.model.JobTypeEntity;

import java.util.Set;

public interface JobTypesToJobTypesEntityMapper extends Mapper<Set<JobTypeEntity>, Set<String>> {

    Set<JobTypeEntity> map(Set<String> source);

}
