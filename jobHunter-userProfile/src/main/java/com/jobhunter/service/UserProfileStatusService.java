package com.jobhunter.service;

import com.jobhunter.enums.UserProfileStatus;
import com.jobhunter.model.UserProfileStatusEntity;

import java.util.Optional;
import java.util.Set;

public interface UserProfileStatusService {

    Optional<UserProfileStatusEntity> getByName(UserProfileStatus name);

    Optional<UserProfileStatusEntity> getById(Integer id);

    Set<UserProfileStatusEntity> getAll();

}
