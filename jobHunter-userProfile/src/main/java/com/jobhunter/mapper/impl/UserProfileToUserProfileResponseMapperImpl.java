package com.jobhunter.mapper.impl;

import com.jobhunter.dto.userProfile.UserProfileResponse;
import com.jobhunter.helper.CollectionHelper;
import com.jobhunter.mapper.CourseEntityToCourseResponseShortMapper;
import com.jobhunter.mapper.EducationEntityToEducationResponseShortMapper;
import com.jobhunter.mapper.ExperienceEntityToExperienceResponseShortMapper;
import com.jobhunter.mapper.UserProfileToUserProfileResponseMapper;
import com.jobhunter.model.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserProfileToUserProfileResponseMapperImpl implements UserProfileToUserProfileResponseMapper {

    private final ExperienceEntityToExperienceResponseShortMapper experienceResponseShortMapper;
    private final CourseEntityToCourseResponseShortMapper courseResponseShortMapper;
    private final EducationEntityToEducationResponseShortMapper educationResponseShortMapper;

    @Override
    public UserProfileResponse map(UserProfile source) {
        return UserProfileResponse.builder()
                .id(source.getId())
                .userId(source.getUserId())
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .title(source.getPosition())
                .description(source.getDescription())
                .birthDate(source.getIsBirthDateVisible() ? source.getBirthDate() : null)
                .isBirthDateVisible(source.getIsBirthDateVisible())
                .cityId(source.getCityId())
                .avatarId(source.getAvatarId())
                .status(source.getStatus().getName())
                .experiences(
                        CollectionHelper.isNullOrEmpty(source.getExperiences())
                                ? Collections.emptySet()
                                : source.getExperiences().stream().map(experienceResponseShortMapper::map).collect(Collectors.toSet()))
                .courses(
                        CollectionHelper.isNullOrEmpty(source.getCourses())
                                ? Collections.emptySet()
                                : source.getCourses().stream().map(courseResponseShortMapper::map).collect(Collectors.toSet()))
                .educations(
                        CollectionHelper.isNullOrEmpty(source.getCourses())
                                ? Collections.emptySet()
                                : source.getEducations().stream().map(educationResponseShortMapper::map).collect(Collectors.toSet()))
                .dateCreated(source.getDateCreated())
                .dateUpdated(source.getDateUpdated())
                .build();
    }
}
