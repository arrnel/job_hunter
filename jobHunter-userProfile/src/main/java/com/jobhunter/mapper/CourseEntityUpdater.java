package com.jobhunter.mapper;

import com.jobhunter.model.CourseEntity;

public interface CourseEntityUpdater extends Updater<CourseEntity>{

    @Override
    CourseEntity update(CourseEntity oldSource, CourseEntity newSource);

}
