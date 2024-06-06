package com.jobhunter.mapper.impl;

import com.jobhunter.dto.experience.ExperienceRequest;
import com.jobhunter.exception.UserProfileNotFoundException;
import com.jobhunter.mapper.ExperienceRequestToExperienceEntityMapper;
import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class ExperienceRequestToExperienceEntityMapperImpl implements ExperienceRequestToExperienceEntityMapper {

    private final UserProfileService userProfileService;

    @Override
    public ExperienceEntity map(ExperienceRequest source) {
        return ExperienceEntity.builder()
                .userProfile(
                        userProfileService.getById(source.getUserProfileId())
                                .orElseThrow(() -> new UserProfileNotFoundException("User profile with id = [%d] not found"
                                        .formatted(source.getUserProfileId())))
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
