package com.jobhunter.mapper.impl;

import com.jobhunter.dto.course.CourseResponseShort;
import com.jobhunter.mapper.CourseEntityToCourseResponseShortMapper;
import com.jobhunter.model.CourseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
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
