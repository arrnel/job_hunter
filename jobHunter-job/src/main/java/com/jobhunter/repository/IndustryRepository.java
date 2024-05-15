package com.jobhunter.repository;

import com.jobhunter.model.IndustryCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndustryRepository extends JpaRepository<IndustryCategoryModel, Integer> {}
