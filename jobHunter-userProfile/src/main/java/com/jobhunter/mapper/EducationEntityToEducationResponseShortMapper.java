package com.jobhunter.mapper;

import com.jobhunter.dto.CourseResponseShort;
import com.jobhunter.dto.ExperienceResponseShort;
import com.jobhunter.model.CourseEntity;
import com.jobhunter.model.ExperienceEntity;

public interface CourseEntityToCourseResponseShortMapper extends Mapper<CourseResponseShort, CourseEntity>{

    @Override
    CourseResponseShort map(CourseEntity source);

}
