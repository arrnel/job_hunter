package com.jobhunter.repository;

import com.jobhunter.model.SpecializationCategoryModel;
import com.jobhunter.model.SpecializationSubCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SpecializationSubRepository extends JpaRepository<SpecializationSubCategoryModel, Integer> {

    Set<SpecializationSubCategoryModel> findByCategory(SpecializationCategoryModel category);

    Set<SpecializationSubCategoryModel> findByIdIn(Set<Integer> ids);

}
