package com.jobhunter.controller;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.UserProfileRequest;
import com.jobhunter.dto.UserProfileResponse;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface UserProfileController {

    UserProfileResponse create(UserProfileRequest request);

    UserProfileResponse getById(Long id);

    Set<UserProfileResponse> getAll(
        String partialTitle
        , String partialDescription
        , String partialContent
        , Long userProfile
        , String statusName
        , Integer statusId
        , Long user
        , String email
        , Integer age
        , Integer city
        , Integer region
        , Integer country
        , String dateFrom
        , String dateTo
        , Pageable pageable
    );

    UserProfileResponse update(Long id, UserProfileRequest request);

    StatusDTO delete(Long id);

}
