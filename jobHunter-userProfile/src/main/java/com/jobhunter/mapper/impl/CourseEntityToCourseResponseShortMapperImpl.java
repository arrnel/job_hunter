package com.jobhunter.mapper.impl;

import com.jobhunter.dto.ExperienceResponseShort;
import com.jobhunter.mapper.ExperienceEntityToExperienceResponseShortMapper;
import com.jobhunter.model.ExperienceEntity;
import org.springframework.stereotype.Component;

@Component
public class ExperienceEntityToExperienceResponseShortMapperImpl implements ExperienceEntityToExperienceResponseShortMapper {

    @Override
    public ExperienceResponseShort map(ExperienceEntity source) {
        return ExperienceResponseShort.builder()
                .id(source.getId())
                .companyId(source.getCompanyId())
                .companyName(source.getCompanyName())
                .position(source.getPosition())
                .description(source.getDescription())
                .from(source.getFrom())
                .to(source.getTo())
                .build();
    }
}
