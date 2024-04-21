package com.jobhunter.repository;

import com.jobhunter.model.City;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor<City> {

    @Override
    Page<City> findAll(@Nullable Specification<City> spec, Pageable pageable);

}
