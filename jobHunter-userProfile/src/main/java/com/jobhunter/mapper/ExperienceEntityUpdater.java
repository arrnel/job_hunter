package com.jobhunter.mapper;

import com.jobhunter.model.ExperienceEntity;

public interface ExperienceEntityUpdater extends Updater<ExperienceEntity> {

    @Override
    ExperienceEntity update(ExperienceEntity oldSource, ExperienceEntity newSource);

}
