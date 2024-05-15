package com.jobhunter.service.impl;

import com.jobhunter.dataParser.CategoryUpdater;
import com.jobhunter.dto.StatusDTO;
import com.jobhunter.enums.ECode;
import com.jobhunter.exception.CategoryNotFoundException;
import com.jobhunter.model.IndustryCategoryModel;
import com.jobhunter.model.IndustrySubCategoryModel;
import com.jobhunter.model.SpecializationCategoryModel;
import com.jobhunter.model.SpecializationSubCategoryModel;
import com.jobhunter.repository.IndustryRepository;
import com.jobhunter.repository.IndustrySubRepository;
import com.jobhunter.repository.SpecializationRepository;
import com.jobhunter.repository.SpecializationSubRepository;
import com.jobhunter.service.CategoryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryUpdater categoryUpdater;
    private final IndustryRepository industryRepository;
    private final IndustrySubRepository industrySubRepository;
    private final SpecializationRepository specializationRepository;
    private final SpecializationSubRepository specializationSubRepository;

    // Info: correct
    @PostConstruct
    public void init() {

        log.info("Checking categories table for update.");
        if (industryRepository.findAll().isEmpty() || industrySubRepository.findAll().isEmpty()
                || specializationRepository.findAll().isEmpty() || specializationSubRepository.findAll().isEmpty()) {
            log.info("Some categories tables is empty. Starting to update categories");
            update();
        }
    }

    // Info: correct
    @Override
    public StatusDTO update() {
        log.info("Starting to update categories tables");
        categoryUpdater.update();
        return new StatusDTO(true);
    }

    // Info: correct
    @Override
    @Transactional(readOnly = true)
    public Set<IndustryCategoryModel> getAllIndustries() {
        return new HashSet<>(industryRepository.findAll());
    }

    // Info: correct
    @Override
    @Transactional(readOnly = true)
    public Set<IndustrySubCategoryModel> getIndustriesSubCategoriesWithIds(Set<Integer> ids) {
        Set<IndustrySubCategoryModel> subCategories = industrySubRepository.findByIdIn(ids);
        if (ids.size() != subCategories.size())
            throw new CategoryNotFoundException(ECode.JOB_CATEGORY_NOT_FOUND);
        return subCategories;
    }

    // Info: correct
    @Override
    @Transactional(readOnly = true)
    public Map<String, Set<IndustrySubCategoryModel>> getIndustriesSubCategories() {
        return industryRepository.findAll().stream().collect(
                Collectors.toMap(
                        IndustryCategoryModel::getName
                        , industrySubRepository::findByCategory, (a, b) -> a, TreeMap::new)
        );
    }

    // Info: correct
    @Override
    @Transactional(readOnly = true)
    public Set<SpecializationCategoryModel> getAllSpecializations() {
        return new HashSet<>(specializationRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Set<SpecializationSubCategoryModel> getSpecializationsSubCategoriesWithIds(Set<Integer> ids) {
        Set<SpecializationSubCategoryModel> subCategories = specializationSubRepository.findByIdIn(ids);
        if (ids.size() != subCategories.size())
            throw new CategoryNotFoundException(ECode.JOB_CATEGORY_NOT_FOUND);
        return subCategories;
    }


    @Override
    @Transactional(readOnly = true)
    public Map<String, Set<SpecializationSubCategoryModel>> getSpecializationsSubCategories() {
        return specializationRepository.findAll().stream().collect(
                Collectors.toMap(
                        SpecializationCategoryModel::getName
                        , specializationSubRepository::findByCategory, (a, b) -> a, TreeMap::new)
        );
    }


}
