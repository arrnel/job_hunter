package com.jobhunter.controller;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.course.CourseRequest;
import com.jobhunter.dto.course.CourseResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public interface CourseController {

    @PostMapping
    @ResponseStatus(CREATED)
    CourseResponse create(
            @Valid @Min(1) @PathVariable("user_profile_id") Long userProfileId
            , @Valid @NonNull @RequestBody CourseRequest requestBody
    );

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    CourseResponse getById(
            @Valid @Min(1) @PathVariable("id") Long id
    );

    @GetMapping
    @ResponseStatus(OK)
    Set<CourseResponse> getByProfileId(
            @Valid @Min(1) @RequestParam("user_profile_id") Long userProfileId
    );

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    CourseResponse update(
            @Valid @Min(1) @PathVariable Long id
            , @Valid @NonNull @RequestBody CourseRequest requestBody
    );

    StatusDTO delete(
            @Valid @Min(1) @PathVariable Long id
    );

}
