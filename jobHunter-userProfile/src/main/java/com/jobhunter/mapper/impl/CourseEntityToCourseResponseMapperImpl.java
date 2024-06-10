package com.jobhunter.mapper.impl;

import com.jobhunter.dto.course.CourseResponse;
import com.jobhunter.mapper.CourseEntityToCourseResponseMapper;
import com.jobhunter.model.CourseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CourseEntityToCourseResponseMapperImpl implements CourseEntityToCourseResponseMapper {

    @Override
    public CourseResponse map(CourseEntity source) {
        return CourseResponse.builder()
                .id(source.getId())
                .userProfile(source.getUserProfile().getId())
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
