package com.jobhunter.mapper;

import com.jobhunter.dto.UserProfileResponse;
import com.jobhunter.model.UserProfile;

public interface UserProfileToUserProfileResponseMapper extends Mapper<UserProfileResponse, UserProfile> {

    @Override
    UserProfileResponse map(UserProfile userProfile);

}
