package com.jobhunter.repository;

import com.jobhunter.model.Country;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {

    Optional<Country> findByName(String name);

    @Override
    Page<Country> findAll(@Nullable Specification<Country> spec, Pageable pageable);

}
