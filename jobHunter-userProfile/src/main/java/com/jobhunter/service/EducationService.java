package com.jobhunter.service;

import com.jobhunter.dto.requestParam.ExperienceFilter;
import com.jobhunter.model.ExperienceEntity;
import lombok.NonNull;

import java.util.Optional;
import java.util.Set;

public interface ExperienceService {

    Optional<ExperienceEntity> getExperienceById(@NonNull Long id);

    Set<ExperienceEntity> getExperiences(ExperienceFilter filter);

}
