package com.jobhunter.controller.impl;

import com.jobhunter.config.Config;
import com.jobhunter.controller.CourseController;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.course.CourseRequest;
import com.jobhunter.dto.course.CourseResponse;
import com.jobhunter.exception.CourseNotFoundException;
import com.jobhunter.exception.TooManyEducationsException;
import com.jobhunter.mapper.CourseEntityToCourseResponseMapper;
import com.jobhunter.mapper.CourseRequestToCourseEntityMapper;
import com.jobhunter.model.CourseEntity;
import com.jobhunter.service.CourseService;
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
public class CourseControllerImpl implements CourseController {

    private final CourseService courseService;
    private final CourseRequestToCourseEntityMapper courseEntityMapper;
    private final CourseEntityToCourseResponseMapper courseResponseMapper;

    @Override
    @PostMapping("/{user_profile_id}/course")
    @ResponseStatus(CREATED)
    public CourseResponse create(
            @Valid @Min(1) @PathVariable("user_profile_id") Long userProfileId
            , @Valid @NonNull @RequestBody CourseRequest requestBody
    ) {

        log.info("Start creating education with requestBody = [{}]", requestBody);

        // Add if user has greater than 10 user profiles then throw TooMachUserProfilesException
        long userId = 1L;

        log.info("Start creating course with requestBody = [{}]", requestBody);
        int totalUserCourses = courseService.getByUserProfile(userProfileId).size(),
                coursesLimit = Config.User.coursesMax();
        if (totalUserCourses >= coursesLimit) throw new TooManyEducationsException();

        return courseResponseMapper.map(
                courseService.create(
                        courseEntityMapper.map(requestBody.setUserProfileId(userProfileId))
                                .setUser(userId)                        // FIXME: REMOVE and add authorization
                                .setDateCreated(LocalDateTime.now())
                ));
    }

    @Override
    @GetMapping("/course/{id}")
    @ResponseStatus(OK)
    public CourseResponse getById(
            @Valid @Min(1) @PathVariable("id") Long id
    ) {
        log.info("Get course with id = [{}]", id);
        return courseResponseMapper.map(
                courseService.getById(id)
                        .orElseThrow(() -> new CourseNotFoundException("Course with id = [%d] not found".formatted(id))));
    }

    @Override
    @GetMapping("/course")
    @ResponseStatus(OK)
    public Set<CourseResponse> getByProfileId(
            @Valid @Min(1) @RequestParam("user_profile_id") Long userProfileId
    ) {
        log.info("Get courses with user_profile_id = [{}]", userProfileId);
        return courseService.getByUserProfile(userProfileId)
                .stream().map(courseResponseMapper::map)
                .collect(Collectors.toSet());
    }

    @Override
    @PutMapping("/course/{id}")
    @ResponseStatus(OK)
    public CourseResponse update(
            @Valid @Min(1) @PathVariable Long id
            , @Valid @NonNull @RequestBody CourseRequest requestBody
    ) {

        log.info("Update course with id = [{}] and requestBody = [{}]", id, requestBody);

        CourseEntity course = courseService.getById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course with id = [%d] not found".formatted(id)));

        return courseResponseMapper.map(
                courseService.update(
                        id
                        , courseEntityMapper.map(requestBody.setUserProfileId(course.getUserProfile().getId())))
        );
    }

    @Override
    @DeleteMapping("/course/{id}")
    @ResponseStatus(OK)
    public StatusDTO delete(@Valid @Min(1) @PathVariable Long id) {
        log.info("Delete course with id = [{}]", id);
        return courseService.delete(id);
    }

}
