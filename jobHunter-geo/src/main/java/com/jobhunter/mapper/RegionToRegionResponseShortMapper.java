package com.jobhunter.mapper;

import com.jobhunter.dto.RegionResponseShort;
import com.jobhunter.model.Region;

public interface RegionToRegionResponseShortMapper extends Mapper<RegionResponseShort, Region> {
    RegionResponseShort map(Region country);
}
