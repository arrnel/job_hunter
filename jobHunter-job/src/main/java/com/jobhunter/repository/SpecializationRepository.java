package com.jobhunter.repository;

import com.jobhunter.model.SpecializationCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecializationRepository extends JpaRepository<SpecializationCategoryModel, Integer> {

    Optional<SpecializationCategoryModel> findByName(String name);

}