package com.jobhunter.mapper.impl;

import com.jobhunter.dto.CompanyResponse;
import com.jobhunter.mapper.CompanyToCompanyResponseMapper;
import com.jobhunter.model.CompanyEntity;

public class CompanyUpdaterImpl implements CompanyToCompanyResponseMapper {

    @Override
    public CompanyResponse map(CompanyEntity source) {
        return CompanyResponse.builder()
                .id(source.getId())
                .email(source.getEmail())
                .name(source.getName())
                .description(source.getDescription())
                .cityId(source.getCityId())
                .address(source.getAddress())
                .users(source.getUsers())
                .dateCreated(source.getDateCreated())
                .dateUpdated(source.getDateUpdated())
                .build();
    }

}
