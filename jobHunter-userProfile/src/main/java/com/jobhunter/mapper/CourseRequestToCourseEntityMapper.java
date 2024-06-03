package com.jobhunter.mapper;

import com.jobhunter.dto.course.CourseRequest;
import com.jobhunter.model.CourseEntity;

public interface CourseRequestToCourseEntityMapper extends Mapper<CourseEntity, CourseRequest>{

    @Override
    CourseEntity map(CourseRequest source);

}
