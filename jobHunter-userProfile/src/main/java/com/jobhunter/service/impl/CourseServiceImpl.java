package com.jobhunter.service.impl;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.exception.ExperienceNotFoundException;
import com.jobhunter.exception.UserProfileNotFoundException;
import com.jobhunter.mapper.CourseEntityUpdater;
import com.jobhunter.model.CourseEntity;
import com.jobhunter.repository.CourseRepository;
import com.jobhunter.service.CourseService;
import com.jobhunter.service.UserProfileService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserProfileService userProfileService;
    private final CourseEntityUpdater courseEntityUpdater;

    @Override
    public CourseEntity create(CourseEntity course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CourseEntity> getById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<CourseEntity> getByUserProfile(Long id) {
        return courseRepository.findByUserProfile(
                userProfileService.getById(id)
                        .orElseThrow(() -> new UserProfileNotFoundException("User profile with id = [" + id + "] not found"))
        );
    }

    @Override
    public CourseEntity update(@NonNull Long id, CourseEntity newCourse) {

        return courseRepository.save(
                courseEntityUpdater.update(
                        courseRepository.findById(id)
                                .orElseThrow(() -> new ExperienceNotFoundException(
                                        "Experience with id = [" + id + "] not found"
                                        , HttpStatus.BAD_REQUEST
                                ))
                        , newCourse));

    }

    @Override
    public StatusDTO delete(Long id) {
        courseRepository.delete(courseRepository.findById(id).orElseThrow(() -> new ExperienceNotFoundException(
                "Experience with id = [" + id + "] not found"
                , HttpStatus.BAD_REQUEST
        )));
        return new StatusDTO(true);
    }

}
