package com.jobhunter.mapper.impl;

import com.jobhunter.dto.SpecializationCategoryResponse;
import com.jobhunter.mapper.SpecializationCategoryToSpecializationCategoryResponseMapper;
import com.jobhunter.model.SpecializationCategoryModel;
import org.springframework.stereotype.Component;

@Component
public class SpecializationCategoryToSpecializationCategoryResponseMapperImpl implements SpecializationCategoryToSpecializationCategoryResponseMapper {

    @Override
    public SpecializationCategoryResponse map(SpecializationCategoryModel source) {
        return SpecializationCategoryResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }

}
