package com.jobhunter.repository;

import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {

    Set<ExperienceEntity> findByUserProfile(UserProfile userProfile);

}

//public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long>, JpaSpecificationExecutor<ExperienceEntity> {
//    @NonNull
//    Set<ExperienceEntity> findAll(Specification<ExperienceEntity> specification);
//}
