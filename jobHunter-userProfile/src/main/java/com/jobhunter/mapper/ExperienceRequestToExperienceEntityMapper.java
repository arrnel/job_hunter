package com.jobhunter.mapper;

import com.jobhunter.dto.experience.ExperienceRequest;
import com.jobhunter.model.ExperienceEntity;

public interface ExperienceRequestToExperienceEntityMapper extends Mapper<ExperienceEntity, ExperienceRequest>{

    @Override
    ExperienceEntity map(ExperienceRequest source);

}
