package com.jobhunter.mapper;

import com.jobhunter.model.UserProfile;

public interface UserProfileUpdater extends Updater<UserProfile> {

    @Override
    UserProfile update(UserProfile oldSource, UserProfile newSource);

}
