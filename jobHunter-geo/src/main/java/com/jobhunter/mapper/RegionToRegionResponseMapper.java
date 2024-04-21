package com.jobhunter.mapper;

import com.jobhunter.dto.RegionResponse;
import com.jobhunter.model.Region;

public interface RegionToRegionResponseMapper extends Mapper<RegionResponse, Region>{
    RegionResponse map(Region regions);
}
