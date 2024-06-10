package com.jobhunter.mapper.impl;

import com.jobhunter.dto.education.EducationResponse;
import com.jobhunter.mapper.EducationEntityToEducationResponseMapper;
import com.jobhunter.model.EducationEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EducationEntityToEducationResponseMapperImpl implements EducationEntityToEducationResponseMapper {

    @Override
    public EducationResponse map(EducationEntity source) {
        return EducationResponse.builder()
                .id(source.getId())
                .userProfile(source.getUserProfile().getId())
                .user(source.getUser())
                .companyId(source.getCompanyId())
                .companyName(source.getCompanyName())
                .position(source.getPosition())
                .description(source.getDescription())
                .from(source.getFrom())
                .to(source.getTo())
                .dateCreated(source.getDateCreated())
                .dateUpdated(source.getDateUpdated())
                .build();
    }
}
