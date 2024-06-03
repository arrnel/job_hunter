package com.jobhunter.helper;

import java.util.Arrays;

public class EnumHelper {

    public static <T extends Enum<?>> T getEnumByNameIgnoreCase(Class<T> enumeration, String name){
        return Arrays.stream(enumeration.getEnumConstants())
                .filter(e -> e.name().equalsIgnoreCase(name)).findAny().orElse(null);
    }

    public static <T extends Enum<?>> T getEnumByName(Class<T> enumeration, String name){
        return Arrays.stream(enumeration.getEnumConstants())
                .filter(e -> e.name().equals(name)).findAny().orElse(null);
    }

}