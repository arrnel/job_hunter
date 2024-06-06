package com.jobhunter.repository;

import com.jobhunter.model.EducationEntity;
import com.jobhunter.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EducationRepository extends JpaRepository<EducationEntity, Long> {

    Set<EducationEntity> findByUserProfile(UserProfile userProfile);

}

// public interface EducationRepository extends JpaRepository<EducationRepository, Long>, JpaSpecificationExecutor<ExperienceEntity> {
// @NonNull
//    Set<ExperienceEntity> findAll(Specification<ExperienceEntity> specification);
// }


