package com.jobhunter.service;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.model.IndustryCategoryModel;
import com.jobhunter.model.IndustrySubCategoryModel;
import com.jobhunter.model.SpecializationCategoryModel;
import com.jobhunter.model.SpecializationSubCategoryModel;

import java.util.Map;
import java.util.Set;

public interface CategoryService {

    StatusDTO update();

    Set<IndustryCategoryModel> getAllIndustries();

    Set<IndustrySubCategoryModel> getIndustriesSubCategoriesWithIds(Set<Integer> ids);

    Map<String, Set<IndustrySubCategoryModel>> getIndustriesSubCategories();

    Set<SpecializationCategoryModel> getAllSpecializations();

    Set<SpecializationSubCategoryModel> getSpecializationsSubCategoriesWithIds(Set<Integer> ids);

    Map<String, Set<SpecializationSubCategoryModel>> getSpecializationsSubCategories();

}
