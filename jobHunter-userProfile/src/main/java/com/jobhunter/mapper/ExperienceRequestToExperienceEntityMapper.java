package com.jobhunter.mapper;

import com.jobhunter.dto.ExperienceResponse;
import com.jobhunter.dto.requestParam.UserProfileFilter;
import com.jobhunter.dto.requestParam.UserProfileFilterValues;
import com.jobhunter.model.ExperienceEntity;

public interface ExperienceEntityToExperienceResponseMapper extends Mapper<ExperienceResponse, ExperienceEntity>{

    @Override
    ExperienceResponse map(ExperienceEntity source);

}
