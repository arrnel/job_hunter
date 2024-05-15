package com.jobhunter.mapper.impl;

import com.jobhunter.dto.JobResponse;
import com.jobhunter.mapper.JobToJobResponseMapper;
import com.jobhunter.model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class JobToJobResponseMapperImpl implements JobToJobResponseMapper {

    @Override
    public JobResponse map(Job source) {

        return JobResponse.builder()
                .id(source.getId())
                .companyId(source.getCompanyId())
                .title(source.getTitle())
                .description(source.getDescription())
                .minPrice(source.getMinPrice())
                .maxPrice(source.getMaxPrice())
                .currency(source.getCurrency())
                .priceType(source.getPriceType().getName())
                .jobTypes(source.getJobTypes().stream().map(JobTypeEntity::getName).collect(Collectors.toSet()))
                .specializations(source.getSpecializationSubCategories().stream().map(SpecializationSubCategoryModel::getId).collect(Collectors.toSet()))
                .industries(source.getIndustriesSubCategories().stream().map(IndustrySubCategoryModel::getId).collect(Collectors.toSet()))
                .cityId(source.getCityId())
                .dateCreated(source.getDateCreated())
                .dateUpdated(source.getDateUpdated())
                .build();

    }

}
