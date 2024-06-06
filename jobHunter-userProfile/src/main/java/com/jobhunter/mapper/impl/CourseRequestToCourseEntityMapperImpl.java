package com.jobhunter.mapper.impl;

import com.jobhunter.dto.course.CourseRequest;
import com.jobhunter.exception.UserProfileNotFoundException;
import com.jobhunter.mapper.CourseRequestToCourseEntityMapper;
import com.jobhunter.model.CourseEntity;
import com.jobhunter.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class CourseRequestToCourseEntityMapperImpl implements CourseRequestToCourseEntityMapper {

    private final UserProfileService userProfileService;

    @Override
    public CourseEntity map(CourseRequest source) {
        return CourseEntity.builder()
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
