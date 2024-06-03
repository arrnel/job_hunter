package com.jobhunter.mapper.impl;

import com.jobhunter.dto.CourseResponse;
import com.jobhunter.dto.ExperienceResponse;
import com.jobhunter.mapper.CourseEntityToCourseResponseMapper;
import com.jobhunter.mapper.ExperienceEntityToExperienceResponseMapper;
import com.jobhunter.model.CourseEntity;
import com.jobhunter.model.ExperienceEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityToCourseResponseMapperImpl implements CourseEntityToCourseResponseMapper {

    @Override
    public CourseResponse map(CourseEntity source) {
        return CourseResponse.builder()
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
