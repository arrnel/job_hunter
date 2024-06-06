package com.jobhunter.mapper;

import com.jobhunter.dto.userProfile.UserProfileRequest;
import com.jobhunter.model.UserProfile;

public interface UserProfileRequestToUserProfileMapper extends Mapper<UserProfile, UserProfileRequest> {

    @Override
    UserProfile map(UserProfileRequest userProfile);

}
