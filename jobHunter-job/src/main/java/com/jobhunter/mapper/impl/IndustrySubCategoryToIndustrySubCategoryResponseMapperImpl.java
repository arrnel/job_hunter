package com.jobhunter.mapper.impl;

import com.jobhunter.dto.IndustrySubCategoryResponse;
import com.jobhunter.mapper.IndustrySubCategoryToIndustrySubCategoryResponseMapper;
import com.jobhunter.model.IndustrySubCategoryModel;
import org.springframework.stereotype.Component;

@Component
public class IndustrySubCategoryToIndustrySubCategoryResponseMapperImpl implements IndustrySubCategoryToIndustrySubCategoryResponseMapper {

    @Override
    public IndustrySubCategoryResponse map(IndustrySubCategoryModel source) {
        return IndustrySubCategoryResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .categoryId(source.getCategory().getId())
                .build();
    }
}
