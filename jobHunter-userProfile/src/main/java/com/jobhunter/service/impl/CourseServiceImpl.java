package com.jobhunter.service.impl;

import com.jobhunter.dto.requestParam.ExperienceFilter;
import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.repository.EducationRepository;
import com.jobhunter.repository.ExperienceRepository;
import com.jobhunter.service.EducationService;
import com.jobhunter.service.ExperienceService;
import com.jobhunter.specification.modelSpecification.ExperienceSpecification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository experienceRepository;

}
