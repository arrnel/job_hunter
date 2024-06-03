package com.jobhunter.controller;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.userProfile.UserProfileRequest;
import com.jobhunter.dto.userProfile.UserProfileResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public interface UserProfileController {

    @PostMapping
    @ResponseStatus(CREATED)
    UserProfileResponse create(
            @NonNull @Valid @RequestBody UserProfileRequest requestBody
    );

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    UserProfileResponse getById(
            @NonNull @Valid @Min(1) @PathVariable("id") Long id
    );

    @GetMapping
    @ResponseStatus(OK)
    PageResponse getAll(
            @RequestParam(value = "partial_title", required = false) String partialTitle,
            @RequestParam(value = "partial_description", required = false) String partialDescription,
            @RequestParam(value = "partial_content", required = false) String partialContent,
            @RequestParam(value = "user_profile_id", required = false) Long userProfile,
            @RequestParam(value = "user_id", required = false) Long user,
            @RequestParam(value = "status_name", required = false) String statusName,
            @RequestParam(value = "status_id", required = false) Integer statusId,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "age_min", required = false) Integer ageMin,
            @RequestParam(value = "age_max", required = false) Integer ageMax,
            @RequestParam(value = "city_id", required = false) Integer city,
            @RequestParam(value = "region_id", required = false) Integer region,
            @RequestParam(value = "country_id", required = false) Integer country,
            @RequestParam(value = "date_from", required = false) String dateFrom,
            @RequestParam(value = "date_to", required = false) String dateTo,
            Pageable pageable
    );

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    UserProfileResponse update(
            @Valid @Min(1) @PathVariable("id") Long id,
            @Valid @RequestBody UserProfileRequest requestBody
    );

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    StatusDTO delete(
            @NonNull @Valid @Min(1) @PathVariable("id") Long id
    );

}