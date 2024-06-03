package com.jobhunter.mapper;

import com.jobhunter.model.EducationEntity;

public interface EducationEntityUpdater extends Updater<EducationEntity>{

    @Override
    EducationEntity update(EducationEntity oldSource, EducationEntity newSource);

}
