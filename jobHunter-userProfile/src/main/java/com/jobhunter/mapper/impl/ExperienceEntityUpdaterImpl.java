package com.jobhunter.mapper.impl;

import com.jobhunter.helper.NumbersHelper;
import com.jobhunter.helper.StringHelper;
import com.jobhunter.mapper.ExperienceEntityUpdater;
import com.jobhunter.model.ExperienceEntity;
import org.springframework.stereotype.Component;

@Component
public class ExperienceEntityUpdaterImpl implements ExperienceEntityUpdater {

    @Override
    public ExperienceEntity update(ExperienceEntity oldSource, ExperienceEntity newSource) {

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
