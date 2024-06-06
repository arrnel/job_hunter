package com.jobhunter.mapper.impl;

import com.jobhunter.helper.NumbersHelper;
import com.jobhunter.helper.StringHelper;
import com.jobhunter.mapper.CourseEntityUpdater;
import com.jobhunter.model.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityUpdaterImpl implements CourseEntityUpdater {

    @Override
    public CourseEntity update(CourseEntity oldSource, CourseEntity newSource) {

        return oldSource.setCompanyId(
                        NumbersHelper.isNullOrZero(newSource.getCompanyId())
                                ? oldSource.getCompanyId()
                                : newSource.getCompanyId()
                )
                .setCompanyName(
                        StringHelper.isNullOrBlank(newSource.getCompanyName())
                                ? oldSource.getCompanyName()
                                : newSource.getCompanyName()
                )
                .setPosition(
                        StringHelper.isNullOrBlank(newSource.getPosition())
                                ? oldSource.getPosition()
                                : newSource.getPosition()
                )
                .setDescription(
                        StringHelper.isNullOrBlank(newSource.getDescription())
                                ? oldSource.getDescription()
                                : newSource.getDescription()
                )
                .setFrom(
                        newSource.getFrom() == null
                                ? oldSource.getFrom()
                                : newSource.getFrom()
                )
                .setTo(
                        newSource.getTo() == null
                                ? oldSource.getTo()
                                : newSource.getTo()
                );

    }
}
