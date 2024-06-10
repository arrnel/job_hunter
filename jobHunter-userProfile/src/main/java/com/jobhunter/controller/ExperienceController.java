package com.jobhunter.controller;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.experience.ExperienceRequest;
import com.jobhunter.dto.experience.ExperienceResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public interface ExperienceController {

    @PostMapping
    @ResponseStatus(CREATED)
    ExperienceResponse create(
            @Valid @Min(1) @PathVariable("user_profile_id") Long userProfileId
            , @Valid @NonNull @RequestBody ExperienceRequest requestBody
    );

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    ExperienceResponse getById(
            @Valid @Min(1) @PathVariable("id") Long id
    );

    @GetMapping
    @ResponseStatus(OK)
    Set<ExperienceResponse> getByProfileId(
            @Valid @Min(1) @RequestParam("user_profile_id") Long userProfileId
    );

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    ExperienceResponse update(
            @Valid @Min(1) @PathVariable("id") Long id
            , @Valid @NonNull @RequestBody ExperienceRequest requestBody
    );

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    StatusDTO delete(
            @Valid @Min(1) @PathVariable("id") Long id
    );

}
