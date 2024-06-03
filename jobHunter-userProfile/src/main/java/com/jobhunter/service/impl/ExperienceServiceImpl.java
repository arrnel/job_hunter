package com.jobhunter.security.impl;

import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.repository.ExperienceRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl {

    private final ExperienceRepository experienceRepository;

    public Optional<ExperienceEntity> getExperienceById(@NonNull Long id){
        return experienceRepository.findById(id);
    }

    public Set<ExperienceEntity> getExperiencesByIds(@NonNull Set<Long> ids){
        return experienceRepository.findByIdIn(ids);
    }

    private Set<ExperienceEntity> getExperiencesByUserProfile(@NonNull Set<Long> ids){
        return experienceRepository.findByUserProfile()
    }

}
