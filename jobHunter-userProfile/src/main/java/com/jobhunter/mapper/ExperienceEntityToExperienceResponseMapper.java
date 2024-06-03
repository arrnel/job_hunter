package com.jobhunter.mapper;

import com.jobhunter.dto.experience.ExperienceResponse;
import com.jobhunter.model.ExperienceEntity;

public interface ExperienceEntityToExperienceResponseMapper extends Mapper<ExperienceResponse, ExperienceEntity>{

    @Override
    ExperienceResponse map(ExperienceEntity source);

}
