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
            @NonNull @Valid @RequestBody CourseRequest requestBody
    );

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    CourseResponse getById(
            @NonNull @Valid @Min(1) @PathVariable("id") Long id
    );

    @GetMapping
    @ResponseStatus(OK)
    Set<CourseResponse> getByProfileId(
            @NonNull @Valid @Min(1) @RequestParam("user_profile_id") Long userProfileId
    );

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    CourseResponse update(
            @NonNull @Valid @Min(1) @PathVariable Long id,
            @NonNull @Valid @RequestBody CourseRequest requestBody
    );

    StatusDTO delete(
            @NonNull @Valid @Min(1) @PathVariable Long id
    );

}
