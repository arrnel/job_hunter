package com.jobhunter.mapper;

import com.jobhunter.dto.course.CourseResponseShort;
import com.jobhunter.model.CourseEntity;

public interface CourseEntityToCourseResponseShortMapper extends Mapper<CourseResponseShort, CourseEntity> {

    @Override
    CourseResponseShort map(CourseEntity source);

}
