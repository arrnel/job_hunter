package com.jobhunter.service.impl;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.exception.ExperienceNotFoundException;
import com.jobhunter.exception.UserProfileNotFoundException;
import com.jobhunter.mapper.EducationEntityUpdater;
import com.jobhunter.model.EducationEntity;
import com.jobhunter.repository.EducationRepository;
import com.jobhunter.service.EducationService;
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
public class EducationServiceImpl implements EducationService {

    private final UserProfileService userProfileService;
    private final EducationRepository educationRepository;
    private final EducationEntityUpdater educationEntityUpdater;

    @Override
    public EducationEntity create(EducationEntity course) {
        return educationRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EducationEntity> getById(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<EducationEntity> getByUserProfile(Long id) {
        return educationRepository.findByUserProfile(
                userProfileService.getById(id)
                        .orElseThrow(() -> new UserProfileNotFoundException("User profile with id = [" + id + "] not found"))
        );
    }

    @Override
    public EducationEntity update(@NonNull Long id, EducationEntity newCourse) {

        return educationRepository.save(
                educationEntityUpdater.update(
                        educationRepository.findById(id)
                                .orElseThrow(() -> new ExperienceNotFoundException(
                                        "Experience with id = [" + id + "] not found"
                                        , HttpStatus.BAD_REQUEST
                                ))
                        , newCourse));
    }

    @Override
    public StatusDTO delete(Long id) {
        educationRepository.delete(
                educationRepository.findById(id).orElseThrow(() -> new ExperienceNotFoundException(
                        "Experience with id = [" + id + "] not found"
                        , HttpStatus.BAD_REQUEST
                )));
        return new StatusDTO(true);
    }

}
