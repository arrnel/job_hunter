package com.jobhunter.repository;

import com.jobhunter.model.Country;
import com.jobhunter.model.Region;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Integer>, JpaSpecificationExecutor<Region> {

    Optional<Region> findByNameAndCountry(String name, Country country);

    @Override
    Page<Region> findAll(@Nullable Specification<Region> spec, Pageable pageable);

}
