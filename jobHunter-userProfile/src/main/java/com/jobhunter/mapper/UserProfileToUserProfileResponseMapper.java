package com.jobhunter.mapper;

import com.jobhunter.dto.userProfile.UserProfileResponse;
import com.jobhunter.model.UserProfile;

public interface UserProfileToUserProfileResponseMapper extends Mapper<UserProfileResponse, UserProfile> {

    @Override
    UserProfileResponse map(UserProfile userProfile);

}
