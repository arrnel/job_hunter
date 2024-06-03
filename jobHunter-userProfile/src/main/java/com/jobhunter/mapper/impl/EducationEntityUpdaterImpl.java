package com.jobhunter.mapper.impl;

import com.jobhunter.helper.NumbersHelper;
import com.jobhunter.helper.StringHelper;
import com.jobhunter.mapper.CourseEntityUpdater;
import com.jobhunter.model.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityUpdaterImpl implements CourseEntityUpdater {

    @Override
    public CourseEntity update(CourseEntity oldCourse, CourseEntity newCourse) {

        return oldCourse.setCompanyId(
                        NumbersHelper.isNullOrZero(newCourse.getCompanyId())
                                ? oldCourse.getCompanyId()
                                : newCourse.getCompanyId()
                )
                .setCompanyName(
                        StringHelper.isNullOrBlank(newCourse.getCompanyName())
                                ? oldCourse.getCompanyName()
                                : newCourse.getCompanyName()
                )
                .setPosition(
                        StringHelper.isNullOrBlank(newCourse.getPosition())
                                ? oldCourse.getPosition()
                                : newCourse.getPosition()
                )
                .setDescription(
                        StringHelper.isNullOrBlank(newCourse.getDescription())
                                ? oldCourse.getDescription()
                                : newCourse.getDescription()
                )
                .setFrom(
                        newCourse.getFrom() == null
                                ? oldCourse.getFrom()
                                : newCourse.getFrom()
                )
                .setTo(
                        newCourse.getTo() == null
                                ? oldCourse.getTo()
                                : newCourse.getTo()
                );

    }
}
