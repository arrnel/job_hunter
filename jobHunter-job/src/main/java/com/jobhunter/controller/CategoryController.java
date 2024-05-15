package com.jobhunter.controller;

import com.jobhunter.dto.IndustryCategoryResponse;
import com.jobhunter.dto.IndustrySubCategoryResponse;
import com.jobhunter.dto.SpecializationCategoryResponse;
import com.jobhunter.dto.SpecializationSubCategoryResponse;

import java.util.Map;
import java.util.Set;

public interface CategoryController {

    Set<IndustryCategoryResponse> getIndustriesList();

    Set<IndustrySubCategoryResponse> getIndustrySubCategoriesWithIds(Set<Integer> ids);

    Map<String, Set<IndustrySubCategoryResponse>> getIndustriesSubCategories();

    Set<SpecializationCategoryResponse> getSpecializationsList();

    Set<SpecializationSubCategoryResponse> getSpecializationSubCategoriesWithIds(Set<Integer> ids);

    Map<String, Set<SpecializationSubCategoryResponse>> getSpecializationsSubCategories();

}
