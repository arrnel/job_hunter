package com.jobhunter.service;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.model.CourseEntity;
import lombok.NonNull;

import java.util.Optional;
import java.util.Set;

public interface CourseService {

    CourseEntity create(CourseEntity course);

    Optional<CourseEntity> getById(Long id);

    Set<CourseEntity> getByUserProfile(Long id);

    CourseEntity update(@NonNull Long id, CourseEntity newCourse);

    StatusDTO delete(Long id);

}
