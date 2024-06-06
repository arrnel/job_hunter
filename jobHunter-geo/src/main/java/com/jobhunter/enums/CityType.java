package com.jobhunter.enums;

import java.util.Optional;

public enum CityType {

    PRIMARY, ADMIN, MINOR;

    public static Optional<CityType> getEnumByName(String name) {
        for (CityType cityType : values())
            if (cityType.name().equalsIgnoreCase(name))
                return Optional.of(cityType);
        return Optional.empty();
    }

}
