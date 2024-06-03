package com.jobhunter.mapper;

import com.jobhunter.dto.CourseResponse;
import com.jobhunter.dto.ExperienceResponse;
import com.jobhunter.model.CourseEntity;
import com.jobhunter.model.ExperienceEntity;

public interface CourseEntityToCourseResponseMapper extends Mapper<CourseResponse, CourseEntity>{

    @Override
    CourseResponse map(CourseEntity source);

}
