package com.jobhunter.service;

import com.jobhunter.dto.queryParamsDTO.CitySearchRequestParams;
import com.jobhunter.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LocationService {

    void init();
    void update();

}
