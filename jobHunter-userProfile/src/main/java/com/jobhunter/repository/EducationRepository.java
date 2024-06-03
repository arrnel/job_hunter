package com.jobhunter.repository;

import com.jobhunter.model.ExperienceEntity;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long>, JpaSpecificationExecutor<ExperienceEntity> {

    @NonNull
    Set<ExperienceEntity> findAll(Specification<ExperienceEntity> specification);


}
