package com.jobhunter.controller.impl;

import com.jobhunter.config.Config;
import com.jobhunter.controller.ExperienceController;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.experience.ExperienceRequest;
import com.jobhunter.dto.experience.ExperienceResponse;
import com.jobhunter.exception.CourseNotFoundException;
import com.jobhunter.exception.ExperienceNotFoundException;
import com.jobhunter.exception.TooManyExperiencesException;
import com.jobhunter.mapper.ExperienceEntityToExperienceResponseMapper;
import com.jobhunter.mapper.ExperienceRequestToExperienceEntityMapper;
import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.service.ExperienceService;
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
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ExperienceControllerImpl implements ExperienceController {

    private final ExperienceService experienceService;
    private final ExperienceRequestToExperienceEntityMapper experienceEntityMapper;
    private final ExperienceEntityToExperienceResponseMapper experienceResponseMapper;

    @Override
    @PostMapping("{user_profile_id}/experience")
    @ResponseStatus(CREATED)
    public ExperienceResponse create(
            @Valid @Min(1) @PathVariable("user_profile_id") Long userProfileId
            , @Valid @NonNull @RequestBody ExperienceRequest requestBody
    ) {
        log.info("Start creating experience with requestBody = [{}]", requestBody);

        // Add if user has greater than 10 user profiles then throw TooMachUserProfilesException
        long userId = 1L;
        int totalUserExperiences = experienceService.getByUserProfile(userProfileId).size(),
                experienceLimit = Config.User.experiencesMax();
        if (totalUserExperiences >= experienceLimit) throw new TooManyExperiencesException();

        return experienceResponseMapper.map(
                experienceService.create(
                        experienceEntityMapper.map(requestBody.setUserProfileId(userProfileId))
                                .setUser(userId)                            // FIXME: REMOVE and add authorization
                                .setDateCreated(LocalDateTime.now())
                ));
    }

    @Override
    @GetMapping("/experience/{id}")
    @ResponseStatus(OK)
    public ExperienceResponse getById(
            @Valid @Min(1) @PathVariable("id") Long id
    ) {
        log.info("Get experience with id = [{}]", id);
        return experienceResponseMapper.map(
                experienceService.getById(id)
                        .orElseThrow(() -> new ExperienceNotFoundException("Experience with id = [%d] not found".formatted(id))));
    }

    @Override
    @GetMapping("/experience")
    @ResponseStatus(OK)
    public Set<ExperienceResponse> getByProfileId(
            @Valid @Min(1) @RequestParam("user_profile_id") Long userProfileId
    ) {
        log.info("Get experiences with user_profile_id = [{}]", userProfileId);
        return experienceService.getByUserProfile(userProfileId)
                .stream().map(experienceResponseMapper::map)
                .collect(Collectors.toSet());
    }

    @Override
    @PutMapping("/experience/{id}")
    @ResponseStatus(OK)
    public ExperienceResponse update(
            @Valid @Min(1) @PathVariable("id") Long id,
            @Valid @NonNull @RequestBody ExperienceRequest requestBody
    ) {
        log.info("Update experience with id = [{}] and requestBody = [{}]", id, requestBody);

        ExperienceEntity experience = experienceService.getById(id)
                .orElseThrow(() -> new CourseNotFoundException("Experience with id = [%d] not found".formatted(id)));

        return experienceResponseMapper.map(
                experienceService.update(
                        id
                        , experienceEntityMapper.map(requestBody.setUserProfileId(experience.getUserProfile().getId())))
        );
    }

    @Override
    @DeleteMapping("/experience/{id}")
    @ResponseStatus(OK)
    public StatusDTO delete(@Valid @Min(1) @PathVariable("id") Long id) {
        log.info("Delete experience with id = [{}]", id);
        return experienceService.delete(id);
    }


}
