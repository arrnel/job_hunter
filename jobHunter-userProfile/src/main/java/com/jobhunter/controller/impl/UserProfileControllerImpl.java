package com.jobhunter.controller.impl;

import com.jobhunter.config.Config;
import com.jobhunter.controller.UserProfileController;
import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.requestParam.UserProfileFilter;
import com.jobhunter.dto.requestParam.UserProfileFilterValues;
import com.jobhunter.dto.userProfile.UserProfileRequest;
import com.jobhunter.dto.userProfile.UserProfileResponse;
import com.jobhunter.exception.TooManyUserProfilesException;
import com.jobhunter.exception.UserProfileNotFoundException;
import com.jobhunter.mapper.*;
import com.jobhunter.model.UserProfile;
import com.jobhunter.service.UserProfileService;
import com.jobhunter.validation.UserProfileValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class UserProfileControllerImpl implements UserProfileController {

    private final UserProfileService userProfileService;
    private final UserProfileValidation userProfileValidation;
    private final PageUserProfileToPageResponseMapper pageUserProfileResponseMapper;
    private final UserProfileFilterValuesToUserProfileFilterMapper userProfileValuesMapper;
    private final UserProfileToUserProfileResponseMapper userProfileResponseMapper;
    private final UserProfileRequestToUserProfileMapper userProfileMapper;
    private final UserProfileUpdater userProfileUpdater;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public UserProfileResponse create(
            @NonNull @Valid @RequestBody UserProfileRequest requestBody
    ) {

        // Add if user has greater than 10 user profiles then throw TooMachUserProfilesException
        long userId = 1L;

        if (userProfileService.getAll(UserProfileFilter.builder().user(userId).build(), Pageable.ofSize(1)).getTotalElements() >= Config.User.profilesMax())
            throw new TooManyUserProfilesException();


        log.info("Create new user profile for user = [{}] and requestBody = [{}]", userId, requestBody);
        return userProfileResponseMapper.map(userProfileService.create(userProfileMapper.map(requestBody)
                .setDateCreated(LocalDateTime.now())
                .setUserId(userId)                          // FIXME: REMOVE and add authorization
        ));

    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public UserProfileResponse getById(
            @NonNull @Valid @Min(1) @PathVariable("id") Long id
    ) {
        return userProfileResponseMapper.map(userProfileService.getById(id)
                .orElseThrow(() -> new UserProfileNotFoundException("User profile with id = [%d] not found".formatted(id))));
    }

    @Override
    @GetMapping
    @ResponseStatus(OK)
    public PageResponse getAll(
            @RequestParam(value = "partial_title", required = false) String partialTitle
            , @RequestParam(value = "partial_description", required = false) String partialDescription
            , @RequestParam(value = "partial_content", required = false) String partialContent
            , @RequestParam(value = "user_profile_id", required = false) Long userProfile
            , @RequestParam(value = "user_id", required = false) Long user
            , @RequestParam(value = "status_name", required = false) String statusName
            , @RequestParam(value = "status_id", required = false) Integer statusId
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "age_min", required = false) Integer ageMin
            , @RequestParam(value = "age_max", required = false) Integer ageMax
            , @RequestParam(value = "city_id", required = false) Integer city
            , @RequestParam(value = "region_id", required = false) Integer region
            , @RequestParam(value = "country_id", required = false) Integer country
            , @RequestParam(value = "date_from", required = false) String dateFrom
            , @RequestParam(value = "date_to", required = false) String dateTo
            , Pageable pageable
    ) {

        UserProfileFilterValues values = UserProfileFilterValues.builder()
                .partialTitle(partialTitle)
                .partialDescription(partialDescription)
                .partialContent(partialContent)
                .statusName(statusName)
                .statusId(statusId)
                .user(user)
                .email(email)
                .ageMin(ageMin)
                .ageMax(ageMax)
                .city(city)
                .region(region)
                .country(country)
                .from(dateFrom)
                .to(dateTo)
                .build();
        log.info("Get all users profiles with request parameters =  {}", values);
        userProfileValidation.validate(values);
        return pageUserProfileResponseMapper.map(userProfileService.getAll(userProfileValuesMapper.map(values), pageable));

    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public UserProfileResponse update(
            @NonNull @Valid @Min(1) @PathVariable("id") Long id,
            @NonNull @Valid @RequestBody UserProfileRequest requestBody
    ) {

        log.info("Find user profile with id = [{}]", id);
        UserProfile oldUserProfile = userProfileService.getById(id)
                .orElseThrow(() -> new UserProfileNotFoundException("User profile with id = [{}] not found"));

        log.info("Updating user profile with id = [{}]", id);
        UserProfile newUserProfile = userProfileService.update(id, userProfileUpdater
                .update(oldUserProfile, userProfileMapper.map(requestBody)));

        log.info("User profile with id = [{}] successfully updated", id);
        return userProfileResponseMapper.map(newUserProfile);

    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public StatusDTO delete(
            @NonNull @Valid @Min(1) @PathVariable("id") Long id
    ) {

        log.info("Removing user profile with id = [{}]", id);
        userProfileService.delete(id);
        log.info("User profile with id = [{}] successfully removed", id);

        return new StatusDTO(true);
    }

}
