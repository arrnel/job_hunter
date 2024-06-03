package com.jobhunter.repository;

import com.jobhunter.model.CourseEntity;
import com.jobhunter.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    Set<CourseEntity> findByUserProfile(UserProfile userProfile);

}
