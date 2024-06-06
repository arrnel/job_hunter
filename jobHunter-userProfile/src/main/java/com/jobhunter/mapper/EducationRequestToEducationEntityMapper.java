package com.jobhunter.mapper;

import com.jobhunter.dto.education.EducationRequest;
import com.jobhunter.model.EducationEntity;

public interface EducationRequestToEducationEntityMapper extends Mapper<EducationEntity, EducationRequest> {

    @Override
    EducationEntity map(EducationRequest source);

}
