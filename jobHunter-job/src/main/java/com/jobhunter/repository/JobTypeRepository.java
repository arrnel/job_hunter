package com.jobhunter.repository;

import com.jobhunter.enums.JobType;
import com.jobhunter.model.JobTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface JobTypeRepository extends JpaRepository<JobTypeEntity, Integer> {

    Optional<JobTypeEntity> getByName(JobType jobType);

    Set<JobTypeEntity> getByNameIn(Set<JobType> jobType);

}
