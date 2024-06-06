package com.jobhunter.mapper;

import com.jobhunter.dto.course.CourseResponse;
import com.jobhunter.model.CourseEntity;

public interface CourseEntityToCourseResponseMapper extends Mapper<CourseResponse, CourseEntity> {

    @Override
    CourseResponse map(CourseEntity source);

}
