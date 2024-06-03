package com.jobhunter.enums;

import com.jobhunter.config.Config;
import com.jobhunter.config.Config.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ECode {

    // @formatter:off
    // INFO: COMMON
    INVALID_REQUEST_PARAM                               ("Request param is invalid", HttpStatus.BAD_REQUEST.value()),
    INVALID_EXTERNAL_LINK                               ("Invalid external link in system parsing method", HttpStatus.BAD_REQUEST.value()),
    REQUEST_PARAMS_COMBINATION_INVALID                  ("Request params invalid combination", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________

    // INFO: AUTH SECTION
    USER_TOKEN_NOT_FOUND                                ("User token not found", HttpStatus.BAD_REQUEST.value()),
    USER_TOKEN_IS_INVALID                               ("Invalid token", HttpStatus.BAD_REQUEST.value()),
    ACCESS_DENIED                                       ("Access denied", HttpStatus.FORBIDDEN.value()),
    UNAUTHORIZED_USER                                   ("User not authorized. Exception from user and user_profiles API", HttpStatus.UNAUTHORIZED.value()),

    //__________________________________________________________________________________________________
    // INFO: USER-SERVICE
    USER_NOT_FOUND                                      ("User not found", HttpStatus.NOT_FOUND.value()),
    USER_ALREADY_EXIST                                  ("User already exists", HttpStatus.BAD_REQUEST.value()),
    USER_PROFILE_NOT_FOUND                              ("User profile not found", HttpStatus.BAD_REQUEST.value()),
    USER_PROFILE_ALREADY_EXIST                          ("User profile already exists", HttpStatus.BAD_REQUEST.value()),
    USER_PROFILE_STATUS_NOT_FOUND                       ("User profile status not found", HttpStatus.BAD_REQUEST.value()),

    USERNAME_IS_REQUIRED                                ("Username is required", HttpStatus.BAD_REQUEST.value()),
    USERNAME_IS_SHORT                                   ("Username is short", HttpStatus.BAD_REQUEST.value()),
    USERNAME_IS_LONG                                    ("Username is long", HttpStatus.BAD_REQUEST.value()),
    USERNAME_IS_INVALID                                 ("Username is invalid", HttpStatus.BAD_REQUEST.value()),
    USERNAME_IS_ALREADY_EXISTS                          ("Username is already exists", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    EMAIL_IS_REQUIRED                                   ("Email is required", HttpStatus.BAD_REQUEST.value()),
    EMAIL_IS_SHORT                                      ("Email is short", HttpStatus.BAD_REQUEST.value()),
    EMAIL_IS_LONG                                       ("Email is long", HttpStatus.BAD_REQUEST.value()),
    EMAIL_IS_INVALID                                    ("Email is invalid", HttpStatus.BAD_REQUEST.value()),
    EMAIL_IS_ALREADY_EXISTS                             ("Email is already exists", HttpStatus.BAD_REQUEST.value()),
    USERNAME_AND_EMAIL_ARE_ALREADY_EXIST                ("Username and email is already exists", HttpStatus.BAD_REQUEST.value()),
    ILLEGAL_SEARCH                                      ("Allowed search only by username or email", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    PASSWORD_IS_REQUIRED                                ("Password is required", HttpStatus.BAD_REQUEST.value()),
    PASSWORD_IS_SHORT                                   ("Password is short", HttpStatus.BAD_REQUEST.value()),
    PASSWORD_IS_LONG                                    ("Password is long", HttpStatus.BAD_REQUEST.value()),
    PASSWORD_IS_INVALID                                 ("Password is invalid", HttpStatus.BAD_REQUEST.value()),
    PASSWORD_IS_NOT_STRONG                              ("Password is not strong", HttpStatus.BAD_REQUEST.value()),
    PASSWORD_IS_NOT_MATCH_CONFIRM                       ("Password is not match password confirmation", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    FIRST_NAME_IS_REQUIRED                              ("First name is required", HttpStatus.BAD_REQUEST.value()),
    FIRST_NAME_IS_SHORT                                 ("First name is short", HttpStatus.BAD_REQUEST.value()),
    FIRST_NAME_IS_LONG                                  ("First name is long", HttpStatus.BAD_REQUEST.value()),
    FIRST_NAME_IS_INVALID                               ("First name is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    LAST_NAME_IS_REQUIRED                               ("Last name is required", HttpStatus.BAD_REQUEST.value()),
    LAST_NAME_IS_SHORT                                  ("Last name is short", HttpStatus.BAD_REQUEST.value()),
    LAST_NAME_IS_LONG                                   ("Last name is long", HttpStatus.BAD_REQUEST.value()),
    LAST_NAME_IS_INVALID                                ("Last name is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    BIRTH_DATE_IS_REQUIRED                              ("Birth date is required", HttpStatus.BAD_REQUEST.value()),
    BIRTH_DATE_FORMAT_IS_INVALID                        ("Birth date format is invalid. Allowed format: dd.mm.yyyy", HttpStatus.BAD_REQUEST.value()),
    BIRTH_DATE_IS_ILLEGAL                               ("Age must between: %d - %d".formatted(User.ageMin(), User.ageMax()), HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    LOCATION_NOT_FOUND                                  ("Location not found", HttpStatus.NOT_FOUND.value()),

    COUNTRY_IS_REQUIRED                                 ("Country name is required", HttpStatus.BAD_REQUEST.value()),
    COUNTRY_NOT_FOUND                                   ("Country not found", HttpStatus.NOT_FOUND.value()),
    COUNTRY_NAME_IS_SHORT                               ("Country name is short", HttpStatus.BAD_REQUEST.value()),
    COUNTRY_NAME_IS_LONG                                ("Country name is long", HttpStatus.BAD_REQUEST.value()),
    COUNTRY_IS_INVALID                                  ("Country name is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    REGION_IS_REQUIRED                                  ("Region name is required", HttpStatus.BAD_REQUEST.value()),
    REGION_NOT_FOUND                                    ("Region not found", HttpStatus.BAD_REQUEST.value()),
    REGION_NAME_IS_SHORT                                ("Region name is short", HttpStatus.BAD_REQUEST.value()),
    REGION_NAME_IS_LONG                                 ("Region name is long", HttpStatus.BAD_REQUEST.value()),
    REGION_IS_INVALID                                   ("Region name is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    CITY_IS_REQUIRED                                    ("City name is required", HttpStatus.BAD_REQUEST.value()),
    CITY_NOT_FOUND                                      ("City not found", HttpStatus.NOT_FOUND.value()),
    CITY_NAME_IS_SHORT                                  ("City name is short", HttpStatus.BAD_REQUEST.value()),
    CITY_NAME_IS_LONG                                   ("City name is long", HttpStatus.BAD_REQUEST.value()),
    CITY_IS_INVALID                                     ("City name is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    COURSE_IS_REQUIRED                                  ("Course name is required", HttpStatus.BAD_REQUEST.value()),
    COURSE_NOT_FOUND                                    ("Course not found", HttpStatus.NOT_FOUND.value()),
    EXCEEDED_THE_COURSE_LIMIT                           ("Too many courses count for user profile. Allowed: %d".formatted(Config.User.coursesMax()), HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    EXPERIENCE_IS_REQUIRED                              ("Experience name is required", HttpStatus.BAD_REQUEST.value()),
    EXPERIENCE_NOT_FOUND                                ("Experience not found", HttpStatus.NOT_FOUND.value()),
    EXCEEDED_THE_EXPERIENCE_LIMIT                       ("Too many experiences count for user profile. Allowed: %d".formatted(Config.User.experiencesMax()), HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    EDUCATION_IS_REQUIRED                               ("Education name is required", HttpStatus.BAD_REQUEST.value()),
    EDUCATION_NOT_FOUND                                 ("Education not found", HttpStatus.NOT_FOUND.value()),
    EXCEEDED_THE_EDUCATION_LIMIT                   ("Too many educations count for user profile. Allowed: %d".formatted(Config.User.educationsMax()), HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________

    USER_ROLE_NOT_FOUND                                 ("User role not found", HttpStatus.BAD_REQUEST.value()),

    //__________________________________________________________________________________________________
    // INFO: LOCATION-SERVICE
    INVALID_DOWNLOAD_LINK                               ("Invalid download link", HttpStatus.BAD_REQUEST.value()),
    FAILED_EXTRACT_FILE                                 ("Failed to extract file", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________

    // INFO: JOB-SERVICE
    JOB_NOT_FOUND                                       ("Job not found", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    JOB_NAME_IS_ALREADY_EXISTS_IN_COMPANY               ("Job name is already exists", HttpStatus.BAD_REQUEST.value()),
    JOB_NAME_REQUIRED                                   ("Job name is required", HttpStatus.BAD_REQUEST.value()),
    JOB_NAME_SHORT                                      ("Job name is short", HttpStatus.BAD_REQUEST.value()),
    JOB_NAME_LONG                                       ("Job name is long", HttpStatus.BAD_REQUEST.value()),
    JOB_NAME_INVALID                                    ("Job name is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    JOB_DESC_REQUIRED                                   ("Job description is required", HttpStatus.BAD_REQUEST.value()),
    JOB_DESC_SHORT                                      ("Job description is short", HttpStatus.BAD_REQUEST.value()),
    JOB_DESC_LONG                                       ("Job description is long", HttpStatus.BAD_REQUEST.value()),
    JOB_DESC_INVALID                                    ("Job description is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    JOB_COMPANY_REQUIRED                                ("Job company is required", HttpStatus.BAD_REQUEST.value()),
    JOB_COMPANY_INVALID                                 ("Job company is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    JOB_MAX_OR_MIN_PRICE_IS_REQUIRED                    ("Job max or min price is required", HttpStatus.BAD_REQUEST.value()),
    JOB_MIN_PRICE_IS_INVALID                            ("Job min price is invalid", HttpStatus.BAD_REQUEST.value()),
    JOB_MIN_PRICE_SHOULD_NOT_EQUALS_OR_BE_LOWER_THAN_0  ("Job min price should not equals 0", HttpStatus.BAD_REQUEST.value()),
    JOB_MAX_PRICE_IS_INVALID                            ("Job max price is invalid", HttpStatus.BAD_REQUEST.value()),
    JOB_MAX_PRICE_SHOULD_NOT_EQUALS_0                   ("Job max price should not equals 0", HttpStatus.BAD_REQUEST.value()),
    JOB_MAX_PRICE_SHOULD_BE_HIGHER_THAN_MIN_PRICE       ("Job max price should be higher min price", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    JOB_CURRENCY_IS_REQUIRED                            ("Job currency is required", HttpStatus.BAD_REQUEST.value()),
    JOB_CURRENCY_IS_INVALID                             ("Job currency is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    JOB_TYPE_IS_REQUIRED                                ("Job type is required", HttpStatus.BAD_REQUEST.value()),
    JOB_TYPE_NOT_FOUND                                  ("Job type not found", HttpStatus.NOT_FOUND.value()),
    JOB_TYPE_IS_INVALID                                 ("Job format is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    PRICE_TYPE_IS_REQUIRED                              ("Price type is required", HttpStatus.BAD_REQUEST.value()),
    PRICE_TYPE_NOT_FOUND                                ("Price type not found", HttpStatus.NOT_FOUND.value()),
    PRICE_TYPE_IS_INVALID                               ("Price format is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    JOB_CATEGORY_IS_REQUIRED                            ("Job category is required", HttpStatus.BAD_REQUEST.value()),
    JOB_CATEGORY_NOT_FOUND                              ("Job category not found", HttpStatus.NOT_FOUND.value()),
    JOB_CATEGORY_IS_INVALID                             ("Job category is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    JOB_LOCATION_IS_REQUIRED                            ("Job location is required", HttpStatus.BAD_REQUEST.value()),
    JOB_LOCATION_IS_SHORT                               ("Job location is short", HttpStatus.BAD_REQUEST.value()),
    JOB_LOCATION_IS_LONG                                ("Job location is long", HttpStatus.BAD_REQUEST.value()),
    JOB_LOCATION_IS_INVALID                             ("Job location is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________

    // INFO: COMPANY-SERVICE
    COMPANY_NOT_FOUND                                   ("Company not found", HttpStatus.NOT_FOUND.value()),
    COMPANY_IS_ALREADY_EXISTS                           ("Company already exists", HttpStatus.BAD_REQUEST.value()),
    COMPANY_EMAIL_OR_NAME_IS_ALREADY_TAKEN              ("Company email or name is already taken", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    COMPANY_NAME_IS_REQUIRED                            ("Company name is required", HttpStatus.BAD_REQUEST.value()),
    COMPANY_NAME_IS_SHORT                               ("Company name is short", HttpStatus.BAD_REQUEST.value()),
    COMPANY_NAME_IS_LONG                                ("Company name is long", HttpStatus.BAD_REQUEST.value()),
    COMPANY_NAME_IS_INVALID                             ("Company name is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    COMPANY_DESC_IS_REQUIRED                            ("Company description is required", HttpStatus.BAD_REQUEST.value()),
    COMPANY_DESC_IS_SHORT                               ("Company description is short", HttpStatus.BAD_REQUEST.value()),
    COMPANY_DESC_IS_LONG                                ("Company description is long", HttpStatus.BAD_REQUEST.value()),
    COMPANY_DESC_IS_INVALID                             ("Company description is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________
    COMPANY_LOCATION_IS_REQUIRED                        ("Company location is required", HttpStatus.BAD_REQUEST.value()),
    COMPANY_LOCATION_IS_SHORT                           ("Company location is short", HttpStatus.BAD_REQUEST.value()),
    COMPANY_LOCATION_IS_LONG                            ("Company location is long", HttpStatus.BAD_REQUEST.value()),
    COMPANY_LOCATION_IS_INVALID                         ("Company location is invalid", HttpStatus.BAD_REQUEST.value()),
    //__________________________________________________________________________________________________

    // INFO: CURRENCY-SERVICE
    CURRENCY_NOT_FOUND                                  ("Currency not found", HttpStatus.NOT_FOUND.value()),
    CURRENCY_UPDATER_FAIL                               ("Failed to download currency info from external resources", HttpStatus.BAD_REQUEST.value()),
    CURRENCY_INFO_DOWNLOAD_FAIL                         ("Failed to download currency info from external resources", HttpStatus.BAD_REQUEST.value()),
    CURRENCY_INFO_PARSER_FAIL                           ("Failed to parse currency rate map", HttpStatus.BAD_REQUEST.value()),
    CURRENCY_INFO_SAVER_FAILED                          ("Failed to save currencies in DB", HttpStatus.BAD_REQUEST.value());
    //__________________________________________________________________________________________________
    // @formatter:on

    private final String message;
    private final Integer statusCode;

}