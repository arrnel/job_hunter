package com.jobhunter.controller;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.education.EducationRequest;
import com.jobhunter.dto.education.EducationResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public interface EducationController {

    @PostMapping
    @ResponseStatus(CREATED)
    EducationResponse create(
            @Valid @Min(1) @PathVariable("user_profile_id") Long userProfileId
            , @Valid @NonNull @RequestBody EducationRequest requestBody
    );

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    EducationResponse getById(
            @Valid @Min(1) @PathVariable("id") Long id
    );

    @GetMapping
    @ResponseStatus(OK)
    Set<EducationResponse> getByProfileId(
            @Valid @Min(1) @RequestParam("user_profile_id") Long userProfileId
    );

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    EducationResponse update(
            @Valid @Min(1) @PathVariable Long id
            , @Valid @NonNull @RequestBody EducationRequest requestBody
    );

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    StatusDTO delete(
            @Valid @Min(1) @PathVariable Long id
    );

}
