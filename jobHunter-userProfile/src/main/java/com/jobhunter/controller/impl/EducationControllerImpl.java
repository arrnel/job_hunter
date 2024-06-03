package com.jobhunter.controller.impl;

import com.jobhunter.controller.ExperienceController;
import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/experience")
@RequiredArgsConstructor
public class ExperienceControllerImpl implements ExperienceController {

    private final ExperienceService experienceService;

    private Set<ExperienceEntity> createExperiences(Set<ExperienceEntity> experienceEntitySet){

    }


}
