package com.jobhunter.mapper.impl;

import com.jobhunter.dto.userProfile.UserProfileStatusResponse;
import com.jobhunter.mapper.UserProfileStatusEntityToUserProfileStatusResponseMapper;
import com.jobhunter.model.UserProfileStatusEntity;
import org.springframework.stereotype.Component;

@Component
public class UserProfileStatusEntityToUserProfileStatusResponseMapperImpl implements UserProfileStatusEntityToUserProfileStatusResponseMapper {

    @Override
    public UserProfileStatusResponse map(UserProfileStatusEntity source) {
        return UserProfileStatusResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
