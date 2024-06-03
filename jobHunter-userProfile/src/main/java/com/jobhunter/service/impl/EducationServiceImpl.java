package com.jobhunter.service.impl;

import com.jobhunter.dto.requestParam.ExperienceFilter;
import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.model.UserProfile;
import com.jobhunter.repository.ExperienceRepository;
import com.jobhunter.service.ExperienceService;
import com.jobhunter.specification.modelSpecification.ExperienceSpecification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ExperienceSpecification experienceSpecification;

    public Optional<ExperienceEntity> getExperienceById(@NonNull Long id){
        return experienceRepository.findById(id);
    }

    public Set<ExperienceEntity> getExperiences(ExperienceFilter filter){
        return experienceRepository.findAll(experienceSpecification.findByCriteria(filter));
    }

}
