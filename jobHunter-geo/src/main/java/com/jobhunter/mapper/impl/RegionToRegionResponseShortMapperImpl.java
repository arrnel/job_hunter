package com.jobhunter.mapper.impl;

import com.jobhunter.dto.RegionResponse;
import com.jobhunter.dto.RegionResponseShort;
import com.jobhunter.mapper.RegionToRegionResponseMapper;
import com.jobhunter.mapper.RegionToRegionResponseShortMapper;
import com.jobhunter.model.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class RegionToRegionResponseShortMapperImpl implements RegionToRegionResponseShortMapper {

    @Override
    public RegionResponseShort map(Region region) {
        return RegionResponseShort.builder()
                .id(region.getId())
                .name(region.getName())
                .build();
    }
}
