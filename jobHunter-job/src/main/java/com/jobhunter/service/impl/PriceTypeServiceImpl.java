package com.jobhunter.service.impl;

import com.jobhunter.enums.PriceType;
import com.jobhunter.model.PriceTypeEntity;
import com.jobhunter.repository.PriceTypeRepository;
import com.jobhunter.service.PriceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceTypeServiceImpl implements PriceTypeService {

    private final PriceTypeRepository priceTypeRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<PriceTypeEntity> getPriceTypeByName(PriceType name) {
        return priceTypeRepository.getByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PriceTypeEntity> getPriceTypeById(Integer id) {
        return priceTypeRepository.findById(id);
    }

}
