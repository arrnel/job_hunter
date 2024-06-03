package com.jobhunter.service;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.requestParam.UserProfileFilter;
import com.jobhunter.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserProfileService {

    UserProfile create(UserProfile newUserProfile);

    Optional<UserProfile> getById(Long id);

    Page<UserProfile> getAll(UserProfileFilter filter, Pageable pageable);

    UserProfile update(Long id, UserProfile newUserProfile);

    StatusDTO delete(Long id);
}
