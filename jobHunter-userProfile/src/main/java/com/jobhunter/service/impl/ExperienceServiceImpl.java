package com.jobhunter.service.impl;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.exception.ExperienceNotFoundException;
import com.jobhunter.exception.UserProfileNotFoundException;
import com.jobhunter.mapper.ExperienceEntityUpdater;
import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.repository.ExperienceRepository;
import com.jobhunter.service.ExperienceService;
import com.jobhunter.service.UserProfileService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final UserProfileService userProfileService;
    private final ExperienceRepository experienceRepository;
    private final ExperienceEntityUpdater experienceEntityUpdater;

    @Override
    public ExperienceEntity create(ExperienceEntity course) {
        return experienceRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ExperienceEntity> getById(Long id) {
        return experienceRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<ExperienceEntity> getByUserProfile(Long id) {
        return experienceRepository.findByUserProfile(
                userProfileService.getById(id)
                        .orElseThrow(() -> new UserProfileNotFoundException("User profile with id = [%d] not found".formatted(id))));
    }

    @Override
    public ExperienceEntity update(@NonNull Long id, ExperienceEntity newExperience) {

        return experienceRepository.save(
                experienceEntityUpdater.update(
                        experienceRepository.findById(id)
                                .orElseThrow(() -> new ExperienceNotFoundException("Experience with id = [%d] not found".formatted(id), BAD_REQUEST))
                        , newExperience));
    }

    @Override
    public StatusDTO delete(Long id) {
        experienceRepository.delete(
                experienceRepository.findById(id)
                        .orElseThrow(() -> new ExperienceNotFoundException("Experience with id = [%d] not found".formatted(id), BAD_REQUEST)));
        return new StatusDTO(true);
    }

}
