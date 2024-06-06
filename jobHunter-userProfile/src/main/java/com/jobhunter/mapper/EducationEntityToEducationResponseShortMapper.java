package com.jobhunter.mapper;

import com.jobhunter.dto.education.EducationResponseShort;
import com.jobhunter.model.EducationEntity;

public interface EducationEntityToEducationResponseShortMapper extends Mapper<EducationResponseShort, EducationEntity> {

    @Override
    EducationResponseShort map(EducationEntity source);

}
