package com.jobhunter.controller.impl;

import com.jobhunter.config.Config;
import com.jobhunter.controller.EducationController;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.education.EducationRequest;
import com.jobhunter.dto.education.EducationResponse;
import com.jobhunter.exception.CourseNotFoundException;
import com.jobhunter.exception.TooManyEducationsException;
import com.jobhunter.mapper.EducationEntityToEducationResponseMapper;
import com.jobhunter.mapper.EducationRequestToEducationEntityMapper;
import com.jobhunter.service.EducationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/profile/education")
@RequiredArgsConstructor
public class EducationControllerImpl implements EducationController {

    private final EducationService educationService;
    private final EducationRequestToEducationEntityMapper educationEntityMapper;
    private final EducationEntityToEducationResponseMapper educationResponseMapper;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public EducationResponse create(
            @NonNull @Valid @RequestBody EducationRequest requestBody
    ) {

        log.info("Start creating education with requestBody = [{}]", requestBody);

        // Add if user has greater than 10 user profiles then throw TooMachUserProfilesException
        long userId = 1L;

        int totalUserEducations = educationService.getByUserProfile(requestBody.getUserProfileId()).size(),
                educationsLimit = Config.User.educationsMax();
        if (totalUserEducations >= educationsLimit) throw new TooManyEducationsException();

        return educationResponseMapper.map(educationService.create(educationEntityMapper.map(requestBody)
                .setUser(userId)                            // FIXME: REMOVE and add authorization
                .setDateCreated(LocalDateTime.now()))
        );
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public EducationResponse getById(
            @NonNull @Valid @Min(1) @PathVariable("id") Long id
    ) {

        log.info("Get education with id = [{}]", id);
        return educationResponseMapper.map(
                educationService.getById(id)
                        .orElseThrow(() -> new CourseNotFoundException("Course with id = [%d] not found".formatted(id))));
    }

    @Override
    @GetMapping
    @ResponseStatus(OK)
    public Set<EducationResponse> getByProfileId(
            @NonNull @Valid @Min(1) @RequestParam("user_profile_id") Long userProfileId
    ) {

        log.info("Get educations with user_profile_id = [{}]", userProfileId);
        return educationService.getByUserProfile(userProfileId)
                .stream().map(educationResponseMapper::map)
                .collect(Collectors.toSet());
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public EducationResponse update(
            @NonNull @Valid @Min(1) @PathVariable Long id,
            @NonNull @Valid @RequestBody EducationRequest requestBody
    ) {
        log.info("Update education with id = [{}] and requestBody = [{}]", id, requestBody);
        return educationResponseMapper.map(educationService.update(id, educationEntityMapper.map(requestBody)));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public StatusDTO delete(
            @NonNull @Valid @Min(1) @PathVariable Long id
    ) {
        log.info("Delete education with id = [{}]", id);
        return educationService.delete(id);
    }

}
