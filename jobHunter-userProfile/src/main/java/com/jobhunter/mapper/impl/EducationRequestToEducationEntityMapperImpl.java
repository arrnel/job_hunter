package com.jobhunter.mapper.impl;

import com.jobhunter.dto.CourseResponse;
import com.jobhunter.dto.EducationResponse;
import com.jobhunter.mapper.CourseEntityToCourseResponseMapper;
import com.jobhunter.mapper.EducationEntityToEducationResponseMapper;
import com.jobhunter.model.CourseEntity;
import com.jobhunter.model.EducationEntity;
import org.springframework.stereotype.Component;

@Component
public class EducationEntityToEducationResponseMapperImpl implements EducationEntityToEducationResponseMapper {

    @Override
    public EducationResponse map(EducationEntity source) {
        return EducationResponse.builder()
                .id(source.getId())
                .userProfile(source.getUserProfile())
                .user(source.getUser())
                .companyId(source.getCompanyId())
                .companyName(source.getCompanyName())
                .position(source.getPosition())
                .description(source.getDescription())
                .from(source.getFrom())
                .to(source.getTo())
                .dateCreated(source.getDateCreated())
                .dateUpdated(source.getDateUpdated())
                .build();
    }
}
