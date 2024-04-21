package com.jobhunter.enums;

import com.jobhunter.config.Config.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ECode {

    // INFO: AUTH SECTION
    USER_TOKEN_NOT_FOUND                                ("User token not found"),
    USER_TOKEN_IS_INVALID                               ("Invalid token"),
    ACCESS_DENIED                                       ("Access denied"),
    UNAUTHORIZED_USER                                   ("User not authorized. Exception from user and user_profiles API"),

    // INFO: USER-SERVICE
    USER_NOT_FOUND                                      ("User not found"),
    USER_ALREADY_EXIST                                  ("User already exists"),
    USER_PROFILE_NOT_FOUND                              ("User profile not found"),
    USER_PROFILE_ALREADY_EXIST                          ("User profile already exists"),

    USERNAME_IS_REQUIRED                                ("Username is required"),
    USERNAME_IS_SHORT                                   ("Username is short"),
    USERNAME_IS_LONG                                    ("Username is long"),
    USERNAME_IS_INVALID                                 ("Username is invalid"),
    USERNAME_IS_ALREADY_EXISTS                          ("Username is already exists"),
    //__________________________________________________________________________________________________
    EMAIL_IS_REQUIRED                                   ("Email is required"),
    EMAIL_IS_SHORT                                      ("Email is short"),
    EMAIL_IS_LONG                                       ("Email is long"),
    EMAIL_IS_INVALID                                    ("Email is invalid"),
    EMAIL_IS_ALREADY_EXISTS                             ("Email is already exists"),
    USERNAME_AND_EMAIL_ARE_ALREADY_EXIST                ("Username and email is already exists"),
    ILLEGAL_SEARCH                                      ("Allowed search only by username or email"),
    //__________________________________________________________________________________________________
    PASSWORD_IS_REQUIRED                                ("Password is required"),
    PASSWORD_IS_SHORT                                   ("Password is short"),
    PASSWORD_IS_LONG                                    ("Password is long"),
    PASSWORD_IS_INVALID                                 ("Password is invalid"),
    PASSWORD_IS_NOT_STRONG                              ("Password is not strong"),
    PASSWORD_IS_NOT_MATCH_CONFIRM                       ("Password is not match password confirmation"),
    //__________________________________________________________________________________________________
    FIRST_NAME_IS_REQUIRED                              ("First name is required"),
    FIRST_NAME_IS_SHORT                                 ("First name is short"),
    FIRST_NAME_IS_LONG                                  ("First name is long"),
    FIRST_NAME_IS_INVALID                               ("First name is invalid"),
    //__________________________________________________________________________________________________
    LAST_NAME_IS_REQUIRED                               ("Last name is required"),
    LAST_NAME_IS_SHORT                                  ("Last name is short"),
    LAST_NAME_IS_LONG                                   ("Last name is long"),
    LAST_NAME_IS_INVALID                                ("Last name is invalid"),
    //__________________________________________________________________________________________________
    BIRTH_DATE_IS_REQUIRED                              ("Birth date is required"),
    BIRTH_DATE_FORMAT_IS_INVALID                        ("Birth date format is invalid. Allowed format: dd.mm.yyyy"),
    BIRTH_DATE_IS_ILLEGAL                               ("Age must be between: " + User.ageMin() +  " - " + User.ageMax()),
    //__________________________________________________________________________________________________
    COUNTRY_IS_REQUIRED                                 ("Country name is required"),
    COUNTRY_NOT_FOUND                                   ("Country not found"),
    COUNTRY_NAME_IS_SHORT("Country name is short"),
    COUNTRY_NAME_IS_LONG("Country name is long"),
    COUNTRY_IS_INVALID                                  ("Country name is invalid"),
    //__________________________________________________________________________________________________
    REGION_IS_REQUIRED                                  ("Region name is required"),
    REGION_NOT_FOUND                                    ("Region not found"),
    REGION_NAME_IS_SHORT                                ("Region name is short"),
    REGION_NAME_IS_LONG                                 ("Region name is long"),
    REGION_IS_INVALID                                   ("Region name is invalid"),
    //__________________________________________________________________________________________________
    CITY_IS_REQUIRED                                    ("City name is required"),
    CITY_NOT_FOUND                                      ("City not found"),
    CITY_NAME_IS_SHORT("City name is short"),
    CITY_NAME_IS_LONG("City name is long"),
    CITY_IS_INVALID                                     ("City name is invalid"),
    //__________________________________________________________________________________________________

    USER_ROLE_NOT_FOUND                                 ("User role not found"),

    // INFO: LOCATION-SERVICE
    INVALID_DOWNLOAD_LINK                               ("Invalid download link"),
    FAILED_EXTRACT_FILE                                 ("Failed to extract file"),
    INVALID_SEARCH_BY_NAME_AND_PARTIAL_NAME             ("Search location by name or partial name"),


    // INFO: JOB-SERVICE
    JOB_001("Job not found"),
    //__________________________________________________________________________________________________
    JOB_NAME_REQUIRED                                   ("Job name is required"),
    JOB_NAME_SHORT                                      ("Job name is short"),
    JOB_NAME_LONG                                       ("Job name is long"),
    JOB_NAME_INVALID                                    ("Job name is invalid"),
    //__________________________________________________________________________________________________
    JOB_DESC_REQUIRED                                   ("Job description is required"),
    JOB_DESC_SHORT                                      ("Job description is short"),
    JOB_DESC_LONG                                       ("Job description is long"),
    JOB_DESC_INVALID                                    ("Job description is invalid"),
    //__________________________________________________________________________________________________
    JOB_COMPANY_REQUIRED                                ("Job company is required"),
    JOB_COMPANY_INVALID                                 ("Job company is invalid"),
    //__________________________________________________________________________________________________
    JOB_MAX_OR_MIN_PRICE_IS_REQUIRED                    ("Job max or min price is required"),
    JOB_MIN_PRICE_IS_INVALID                            ("Job min price is invalid"),
    JOB_MIN_PRICE_SHOULD_NOT_EQUALS_OR_BE_LOWER_THAN_0  ("Job min price should not equals 0"),
    JOB_MAX_PRICE_IS_INVALID                            ("Job max price is invalid"),
    JOB_MAX_PRICE_SHOULD_NOT_EQUALS_0                   ("Job max price should not equals 0"),
    JOB_MAX_PRICE_SHOULD_BE_HIGHER_THAN_MIN_PRICE       ("Job max price should be higher min price"),
    //__________________________________________________________________________________________________
    JOB_CURRENCY_IS_REQUIRED                            ("Job currency is required"),
    JOB_CURRENCY_IS_INVALID                             ("Job currency is invalid"),
    //__________________________________________________________________________________________________
    JOB_FORMAT_IS_REQUIRED                              ("Job format is required"),
    JOB_FORMAT_IS_INVALID                               ("Job format is invalid"),
    //__________________________________________________________________________________________________
    JOB_LOCATION_IS_REQUIRED                            ("Job location is required"),
    JOB_LOCATION_IS_SHORT                               ("Job location is short"),
    JOB_LOCATION_IS_LONG                                ("Job location is long"),
    JOB_LOCATION_IS_INVALID                             ("Job location is invalid"),

    // INFO: COMPANY-SERVICE
    COMPANY_NOT_FOUND                                   ("Company not found"),
    //__________________________________________________________________________________________________
    COMPANY_NAME_IS_REQUIRED                            ("Company name is required"),
    COMPANY_NAME_IS_SHORT                               ("Company name is short"),
    COMPANY_NAME_IS_LONG                                ("Company name is long"),
    COMPANY_NAME_IS_INVALID                             ("Company name is invalid"),
    //__________________________________________________________________________________________________
    COMPANY_DESC_IS_REQUIRED                            ("Company description is required"),
    COMPANY_DESC_IS_SHORT                               ("Company description is short"),
    COMPANY_DESC_IS_LONG                                ("Company description is long"),
    COMPANY_DESC_IS_INVALID                             ("Company description is invalid"),
    //__________________________________________________________________________________________________
    COMPANY_LOCATION_IS_REQUIRED                        ("Company location is required"),
    COMPANY_LOCATION_IS_SHORT                           ("Company location is short"),
    COMPANY_LOCATION_IS_LONG                            ("Company location is long"),
    COMPANY_LOCATION_IS_INVALID                         ("Company location is invalid"),
    //__________________________________________________________________________________________________

    // INFO: CURRENCY-SERVICE
    CURRENCY_NOT_FOUND                                  ("Currency not found"),
    CURRENCY_INFO_DOWNLOAD_FAIL                         ("Failed to download currency info from external resources"),
    CURRENCY_INFO_PARSER_FAIL                           ("Failed to parse currency rate map"),
    CURRENCY_INFO_SAVER_FAILED                          ("Failed to save currencies in DB");
    //__________________________________________________________________________________________________
    private final String message;

}