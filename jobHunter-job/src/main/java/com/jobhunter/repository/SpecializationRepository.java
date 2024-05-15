package com.jobhunter.repository;

import com.jobhunter.model.SpecializationCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<SpecializationCategoryModel, Integer> {}