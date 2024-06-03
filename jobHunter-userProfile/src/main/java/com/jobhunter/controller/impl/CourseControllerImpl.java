package com.jobhunter.controller.impl;

import com.jobhunter.controller.EducationController;
import com.jobhunter.controller.ExperienceController;
import com.jobhunter.model.EducationEntity;
import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/education")
@RequiredArgsConstructor
public class EducationControllerImpl implements EducationController {

    private final EducationService educationService;



}
