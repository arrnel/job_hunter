package com.jobhunter.controller.impl;

import com.jobhunter.controller.CategoryController;
import com.jobhunter.dto.IndustryCategoryResponse;
import com.jobhunter.dto.IndustrySubCategoryResponse;
import com.jobhunter.dto.SpecializationCategoryResponse;
import com.jobhunter.dto.SpecializationSubCategoryResponse;
import com.jobhunter.mapper.IndustryCategoryToIndustryCategoryResponseMapper;
import com.jobhunter.mapper.IndustrySubCategoryToIndustrySubCategoryResponseMapper;
import com.jobhunter.mapper.SpecializationCategoryToSpecializationCategoryResponseMapper;
import com.jobhunter.mapper.SpecializationSubCategoryToSpecializationSubCategoryResponseMapper;
import com.jobhunter.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/job/categories")
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;
    private final IndustryCategoryToIndustryCategoryResponseMapper industryCategoryResponseMapper;
    private final IndustrySubCategoryToIndustrySubCategoryResponseMapper industrySubCategoryResponseMapper;
    private final SpecializationCategoryToSpecializationCategoryResponseMapper specializationCategoryResponseMapper;
    private final SpecializationSubCategoryToSpecializationSubCategoryResponseMapper specializationSubCategoryResponseMapper;

    // Info: Set of all industry names with ids
    @Override
    @GetMapping("/industry")
    @ResponseStatus(OK)
    public Set<IndustryCategoryResponse> getIndustriesList() {
        log.info("Get industry categories data");
        return categoryService.getAllIndustries().stream().map(industryCategoryResponseMapper::map).collect(Collectors.toSet());
    }

    // Info: Set of industry subcategories with expected ids
    @Override
    @PostMapping("/industry/sub")
    @ResponseStatus(OK)
    public Set<IndustrySubCategoryResponse> getIndustrySubCategoriesWithIds(@RequestParam("id") Set<Integer> ids) {
        log.info("Get industries subcategories with ids = [{}]", ids.toString());
        return categoryService
                .getIndustriesSubCategoriesWithIds(ids)
                .stream().map(industrySubCategoryResponseMapper::map)
                .collect(Collectors.toSet());
    }

    // Info: Set of all industries with subcategories
    @Override
    @GetMapping("/industry/tree")
    @ResponseStatus(OK)
    public Map<String, Set<IndustrySubCategoryResponse>> getIndustriesSubCategories() {

        log.info("Get industries subcategories data");

        return categoryService.getIndustriesSubCategories().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream()
                                .map(industrySubCategoryResponseMapper::map)
                                .collect(Collectors.toSet())
                ));

    }

    // Info: Set of all specialization names with ids
    @Override
    @GetMapping("/specialization")
    @ResponseStatus(OK)
    public Set<SpecializationCategoryResponse> getSpecializationsList() {
        log.info("Get specialization categories data");
        return categoryService.getAllSpecializations().stream().map(specializationCategoryResponseMapper::map).collect(Collectors.toSet());
    }

    // Info: Set of specialization subcategories with expected ids
    @Override
    @PostMapping("/specialization/sub")
    @ResponseStatus(OK)
    public Set<SpecializationSubCategoryResponse> getSpecializationSubCategoriesWithIds(@RequestParam("id") Set<Integer> ids) {
        log.info("Get specialization subcategories with ids = [{}]", ids.toString());
        return categoryService
                .getSpecializationsSubCategoriesWithIds(ids)
                .stream().map(specializationSubCategoryResponseMapper::map)
                .collect(Collectors.toSet());
    }

    // Info: Set of all specializations with subcategories
    @Override
    @GetMapping("/specialization/tree")
    @ResponseStatus(OK)
    public Map<String, Set<SpecializationSubCategoryResponse>> getSpecializationsSubCategories() {
        log.info("Get specializations subcategories data");
        return categoryService.getSpecializationsSubCategories().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(specializationSubCategoryResponseMapper::map)
                                .collect(Collectors.toSet())
                ));
    }

}
