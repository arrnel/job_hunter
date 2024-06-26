package com.jobhunter.service;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.model.EducationEntity;
import lombok.NonNull;

import java.util.Optional;
import java.util.Set;

public interface EducationService {

    EducationEntity create(EducationEntity course);

    Optional<EducationEntity> getById(Long id);

    Set<EducationEntity> getByUserProfile(Long id);

    EducationEntity update(@NonNull Long id, EducationEntity newCourse);

    StatusDTO delete(Long id);

}
