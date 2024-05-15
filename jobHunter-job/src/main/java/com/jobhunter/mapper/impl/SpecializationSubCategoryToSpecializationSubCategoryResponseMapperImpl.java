package com.jobhunter.mapper.impl;

import com.jobhunter.dto.SpecializationSubCategoryResponse;
import com.jobhunter.mapper.SpecializationSubCategoryToSpecializationSubCategoryResponseMapper;
import com.jobhunter.model.SpecializationSubCategoryModel;
import org.springframework.stereotype.Component;

@Component
public class SpecializationSubCategoryToSpecializationSubCategoryResponseMapperImpl implements SpecializationSubCategoryToSpecializationSubCategoryResponseMapper {

    @Override
    public SpecializationSubCategoryResponse map(SpecializationSubCategoryModel source) {
        return SpecializationSubCategoryResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .categoryId(source.getCategory().getId())
                .build();
    }
}
