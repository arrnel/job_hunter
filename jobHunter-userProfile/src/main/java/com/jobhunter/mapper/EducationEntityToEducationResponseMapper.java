package com.jobhunter.mapper;

import com.jobhunter.dto.education.EducationResponse;
import com.jobhunter.model.EducationEntity;

public interface EducationEntityToEducationResponseMapper extends Mapper<EducationResponse, EducationEntity> {

    @Override
    EducationResponse map(EducationEntity source);

}
