package com.jobhunter.mapper.impl;

import com.jobhunter.dto.education.EducationResponseShort;
import com.jobhunter.mapper.EducationEntityToEducationResponseShortMapper;
import com.jobhunter.model.EducationEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EducationEntityToEducationResponseShortMapperImpl implements EducationEntityToEducationResponseShortMapper {

    @Override
    public EducationResponseShort map(EducationEntity source) {
        return EducationResponseShort.builder()
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
