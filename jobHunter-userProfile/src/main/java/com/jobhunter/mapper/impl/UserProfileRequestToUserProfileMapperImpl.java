package com.jobhunter.mapper.impl;

import com.jobhunter.dto.userProfile.UserProfileRequest;
import com.jobhunter.enums.UserProfileStatus;
import com.jobhunter.exception.UserProfileStatusNotFoundException;
import com.jobhunter.helper.EnumHelper;
import com.jobhunter.mapper.UserProfileRequestToUserProfileMapper;
import com.jobhunter.model.UserProfile;
import com.jobhunter.service.UserProfileStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class UserProfileRequestToUserProfileMapperImpl implements UserProfileRequestToUserProfileMapper {

    private final UserProfileStatusService userProfileStatusService;

    @Override
    public UserProfile map(UserProfileRequest source) {

        return UserProfile.builder()
                .email(source.getEmail().toLowerCase())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .position(source.getPosition())
                .description(source.getDescription())
                .birthDate(source.getBirthDate())
                .isBirthDateVisible(source.getIsBirthDateVisible())
                .cityId(source.getCityId())
                .avatarId(source.getAvatarId())
                .status(
                        userProfileStatusService.getByName(
                                        EnumHelper.getEnumByNameIgnoreCase(UserProfileStatus.class, source.getStatus()))
                                .orElseThrow(() -> new UserProfileStatusNotFoundException("User profile status with name = [" + source.getStatus() + "] not found")))
                .build();
    }
}
