package com.jobhunter.mapper;

import com.jobhunter.dto.experience.ExperienceResponseShort;
import com.jobhunter.model.ExperienceEntity;

public interface ExperienceEntityToExperienceResponseShortMapper extends Mapper<ExperienceResponseShort, ExperienceEntity> {

    @Override
    ExperienceResponseShort map(ExperienceEntity source);

}
