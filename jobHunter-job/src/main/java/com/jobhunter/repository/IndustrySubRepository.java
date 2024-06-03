package com.jobhunter.repository;

import com.jobhunter.model.IndustryCategoryModel;
import com.jobhunter.model.IndustrySubCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface IndustrySubRepository extends JpaRepository<IndustrySubCategoryModel, Integer> {

    Set<IndustrySubCategoryModel> findByCategory(IndustryCategoryModel category);

    Set<IndustrySubCategoryModel> findByIdIn(Set<Integer> ids);

    Optional<IndustrySubCategoryModel> findByName(String name);

}
