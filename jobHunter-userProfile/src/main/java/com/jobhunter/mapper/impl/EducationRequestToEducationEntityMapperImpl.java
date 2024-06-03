package com.jobhunter.mapper.impl;

import com.jobhunter.dto.education.EducationRequest;
import com.jobhunter.exception.UserProfileNotFoundException;
import com.jobhunter.mapper.EducationRequestToEducationEntityMapper;
import com.jobhunter.model.EducationEntity;
import com.jobhunter.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class EducationRequestToEducationEntityMapperImpl implements EducationRequestToEducationEntityMapper {

    private final UserProfileService userProfileService;

    @Override
    public EducationEntity map(EducationRequest source) {
        return EducationEntity.builder()
                .userProfile(
                        userProfileService.getById(source.getUserProfileId())
                                .orElseThrow(() -> new UserProfileNotFoundException("User profile with id = [" + source.getUserProfileId() + "] not found"))
                )
                .companyId(source.getCompanyId())
                .companyName(source.getCompanyName())
                .position(source.getPosition())
                .description(source.getDescription())
                .from(source.getFrom())
                .to(source.getTo())
                .build();
    }
}
