package com.jobhunter.model;

import java.time.LocalDate;
import java.util.UUID;

public class UserJson {

    private UUID id;
    private String username;
    private String firstName;
    private String LastName;
    private String avatar;
    private LocalDate birthDate;
    private CityJson cityId;
    private RegionJson regionId;
    private CountryJson countryId;

}
