package com.jobhunter.controller.impl;

import com.jobhunter.controller.UserProfileController;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.UserProfileRequest;
import com.jobhunter.dto.UserProfileResponse;
import com.jobhunter.dto.requestParam.UserProfileFilterValues;
import com.jobhunter.exception.UserProfileNotFoundException;
import com.jobhunter.mapper.UserProfileFilterValuesToUserProfileFilterMapper;
import com.jobhunter.mapper.UserProfileRequestToUserProfileMapper;
import com.jobhunter.mapper.UserProfileToUserProfileResponseMapper;
import com.jobhunter.mapper.UserProfileUpdater;
import com.jobhunter.model.UserProfile;
import com.jobhunter.service.UserProfileService;
import com.jobhunter.validation.UserProfileValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class UserProfileControllerImpl implements UserProfileController {

    private final UserProfileService userProfileService;
    private final UserProfileValidation userProfileValidation;
    private final UserProfileFilterValuesToUserProfileFilterMapper userProfileValuesMapper;
    private final UserProfileToUserProfileResponseMapper userProfileResponseMapper;
    private final UserProfileRequestToUserProfileMapper userProfileMapper;
    private final UserProfileUpdater userProfileUpdater;

    @Override
    @PostMapping
    public UserProfileResponse create(UserProfileRequest request) {
        
    }

    @Override
    @GetMapping("/{id}")
    public UserProfileResponse getById(
            @Valid @Min(1) @PathVariable("id") Long id
    ) {

    }

    @Override
    @GetMapping("/")
    public Set<UserProfileResponse> getAll(
            @RequestParam(value = "partial_title", required = false) String partialTitle
            , @RequestParam(value = "partial_description", required = false) String partialDescription
            , @RequestParam(value = "partial_content", required = false) String partialContent
            , @RequestParam(value = "status_name", required = false) String statusName
            , @RequestParam(value = "status_id", required = false) Integer statusId
            , @RequestParam(value = "user", required = false) Long user
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

        userProfileValidation.validate(values);

        return userProfileService.getAll(userProfileValuesMapper.map(values))
                .stream().map(userProfileResponseMapper::map)
                .collect(Collectors.toSet());

    }

    @Override
    @PutMapping("/{id}")
    public UserProfileResponse update(
            @Valid @Min(1) @PathVariable Long id,
            @RequestBody UserProfileRequest request
    ) {

        log.info("Find user profile with id = [{}]", id);
        UserProfile oldUserProfile = userProfileService.getById(id)
                .orElseThrow(() -> new UserProfileNotFoundException("User profile with id = [{}] not found"));

        log.info("Updating user profile with id = [{}]", id);
        UserProfile newUserProfile = userProfileService.update(id, userProfileUpdater
                .update(oldUserProfile, userProfileMapper.map(request)));

        log.info("User profile with id = [{}] successfully updated", id);
        return userProfileResponseMapper.map(newUserProfile);

    }

    @Override
    @DeleteMapping("/{id}")
    public StatusDTO delete(
            @Valid @Min(1) @PathVariable("id") Long id
    ) {

        log.info("Removing user profile with id = [{}]", id);
        userProfileService.delete(id);
        log.info("User profile with id = [{}] successfully removed", id);

        return new StatusDTO(true);
    }

}
