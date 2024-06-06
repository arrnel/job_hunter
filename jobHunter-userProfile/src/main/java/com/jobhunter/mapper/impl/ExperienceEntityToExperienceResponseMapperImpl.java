package com.jobhunter.mapper.impl;

import com.jobhunter.dto.experience.ExperienceResponse;
import com.jobhunter.mapper.ExperienceEntityToExperienceResponseMapper;
import com.jobhunter.model.ExperienceEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ExperienceEntityToExperienceResponseMapperImpl implements ExperienceEntityToExperienceResponseMapper {

    @Override
    public ExperienceResponse map(ExperienceEntity source) {
        return ExperienceResponse.builder()
                .id(source.getId())
                .userProfileId(source.getUserProfile().getId())
                .userId(source.getUser())
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
