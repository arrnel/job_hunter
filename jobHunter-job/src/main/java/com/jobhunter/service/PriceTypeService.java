package com.jobhunter.service;

import com.jobhunter.enums.PriceType;
import com.jobhunter.model.PriceTypeEntity;

import java.util.Optional;

public interface PriceTypeService {
    Optional<PriceTypeEntity> getPriceTypeByName(PriceType name);

    Optional<PriceTypeEntity> getPriceTypeById(Integer id);
}
