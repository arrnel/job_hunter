package com.jobhunter.service;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.model.ExperienceEntity;
import lombok.NonNull;

import java.util.Optional;
import java.util.Set;

public interface ExperienceService {

    ExperienceEntity create(ExperienceEntity course);

    Optional<ExperienceEntity> getById(Long id);

    Set<ExperienceEntity> getByUserProfile(Long id);

    ExperienceEntity update(@NonNull Long id, ExperienceEntity newCourse);

    StatusDTO delete(Long id);

}
