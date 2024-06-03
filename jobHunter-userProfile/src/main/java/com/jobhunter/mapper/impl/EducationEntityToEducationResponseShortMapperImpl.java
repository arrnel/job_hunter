package com.jobhunter.mapper.impl;

import com.jobhunter.dto.CourseResponseShort;
import com.jobhunter.dto.ExperienceResponseShort;
import com.jobhunter.mapper.CourseEntityToCourseResponseShortMapper;
import com.jobhunter.mapper.ExperienceEntityToExperienceResponseShortMapper;
import com.jobhunter.model.CourseEntity;
import com.jobhunter.model.ExperienceEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityToCourseResponseShortMapperImpl implements CourseEntityToCourseResponseShortMapper {

    @Override
    public CourseResponseShort map(CourseEntity source) {
        return CourseResponseShort.builder()
                .id(source.getId())
                .companyId(source.getCompanyId())
                .companyName(source.getCompanyName())
                .position(source.getPosition())
                .description(source.getDescription())
                .from(source.getFrom())
                .to(source.getTo())
                .build();
    }
}
