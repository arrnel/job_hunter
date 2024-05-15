package com.jobhunter.repository;

import com.jobhunter.enums.PriceType;
import com.jobhunter.model.PriceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriceTypeRepository extends JpaRepository<PriceTypeEntity, Integer> {

    Optional<PriceTypeEntity> getByName(PriceType name);

}
