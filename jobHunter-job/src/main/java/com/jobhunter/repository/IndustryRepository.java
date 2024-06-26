package com.jobhunter.repository;

import com.jobhunter.model.IndustryCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndustryRepository extends JpaRepository<IndustryCategoryModel, Integer> {

    Optional<IndustryCategoryModel> findByName(String name);

}
