package com.jobhunter.service;

import com.jobhunter.enums.PriceType;
import com.jobhunter.model.PriceTypeEntity;

import java.util.List;
import java.util.Optional;

public interface JobPriceTypeService {

    Optional<PriceTypeEntity> getById(Integer id);

    Optional<PriceTypeEntity> getByName(PriceType jobType);

    List<PriceTypeEntity> getAll();

}
