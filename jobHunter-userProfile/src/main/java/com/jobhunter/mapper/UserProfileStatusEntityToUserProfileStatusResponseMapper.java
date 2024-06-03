package com.jobhunter.mapper;

import com.jobhunter.dto.userProfile.UserProfileStatusResponse;
import com.jobhunter.model.UserProfileStatusEntity;

public interface UserProfileStatusEntityToUserProfileStatusResponseMapper extends Mapper<UserProfileStatusResponse, UserProfileStatusEntity> {

    @Override
    UserProfileStatusResponse map(UserProfileStatusEntity userProfile);

}
