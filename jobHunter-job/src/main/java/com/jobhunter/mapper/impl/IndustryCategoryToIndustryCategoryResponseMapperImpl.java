package com.jobhunter.mapper.impl;

import com.jobhunter.dto.IndustryCategoryResponse;
import com.jobhunter.mapper.IndustryCategoryToIndustryCategoryResponseMapper;
import com.jobhunter.model.IndustryCategoryModel;
import org.springframework.stereotype.Component;

@Component
public class IndustryCategoryToIndustryCategoryResponseMapperImpl implements IndustryCategoryToIndustryCategoryResponseMapper {

    @Override
    public IndustryCategoryResponse map(IndustryCategoryModel source) {
        return IndustryCategoryResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }

}
