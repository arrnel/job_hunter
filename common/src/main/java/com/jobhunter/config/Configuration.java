package com.jobhunter.config;

import org.aeonbits.owner.Config;

public interface Configuration extends Config {

    // INFO: common
    @Key("common.port.jobhunter_auth")
    @DefaultValue("9000")
    Integer jobHunterAuthPort();

    @Key("common.port.jobhunter_comments")
    @DefaultValue("9002")
    Integer jobHunterCommentsPort();

    @Key("common.port.jobhunter_company")
    @DefaultValue("9003")
    Integer jobHunterCompanyPort();

    @Key("common.port.jobhunter_currency")
    @DefaultValue("9004")
    Integer jobHunterCurrencyPort();

    @Key("common.port.jobhunter_cv")
    @DefaultValue("9005")
    Integer jobHunterUserProfilePort();

    @Key("common.port.jobhunter_files")
    @DefaultValue("9006")
    Integer jobHunterFilesPort();

    @Key("common.port.jobhunter_front")
    @DefaultValue("8080")
    Integer jobHunterFrontPort();

    @Key("common.port.jobhunter_gateway")
    @DefaultValue("9007")
    Integer jobHunterGatewayPort();

    @Key("common.port.jobhunter_geo")
    @DefaultValue("9008")
    Integer jobHunterGeoPort();

    @Key("common.port.jobhunter_job")
    @DefaultValue("9009")
    Integer jobHunterJobPort();

    @Key("common.port.jobhunter_notification")
    @DefaultValue("9010")
    Integer jobHunterNotificationPort();

    @Key("common.port.jobhunter_user")
    @DefaultValue("9011")
    Integer jobHunterUserPort();

    // _________________________________________________________________________________________________________________
    // INFO: jobHunter-auth
    // _________________________________________________________________________________________________________________
    // INFO: jobHunter-comments
    // _________________________________________________________________________________________________________________
    // INFO: jobHunter-company
    // _________________________________________________________________________________________________________________

    // INFO: jobHunter-currency
    @Key("currency.default")
    @DefaultValue("USD")
    String defaultCurrency();

    @Key("currency.active_currencies")
    @Separator(",")
    @DefaultValue("USD, EUR, RUB, GBP, CNY, JPY, CAD, KZT")
    String[] activeCurrencies();
    // _________________________________________________________________________________________________________________

    // INFO: jobHunter-files
    // _________________________________________________________________________________________________________________

    // INFO: jobHunter-frontend
    // _________________________________________________________________________________________________________________

    // INFO: jobHunter-geo
    @Key("job_hunter.geo.file.version")
    @DefaultValue("1.77")
    String geoFileVersion();
    // _________________________________________________________________________________________________________________

    // INFO: jobHunter-job
    @Key("job.file.categories")
    @DefaultValue("files/categories.json")
    String pathToCategoriesFile();

    // INFO: jobHunter-notification
    // _________________________________________________________________________________________________________________

    // INFO: jobHunter-user && jobHunter-userProfile
    @Key("user.username.min_length")
    @DefaultValue("4")
    Integer usernameMinLength();

    @Key("user.username.max_length")
    @DefaultValue("50")
    Integer usernameMaxLength();

    @Key("user.email.min_length")
    @DefaultValue("9")
    Integer emailMinLength();

    @Key("user.email.max_length")
    @DefaultValue("50")
    Integer emailMaxLength();

    @Key("user.password.min_length")
    @DefaultValue("8")
    Integer passwordMinLength();

    @Key("user.password.max_length")
    @DefaultValue("50")
    Integer passwordMaxLength();

    @Key("user.first_name.min_length")
    @DefaultValue("2")
    Integer firstNameMinLength();

    @Key("user.first_name.max_length")
    @DefaultValue("50")
    Integer firstNameMaxLength();

    @Key("user.last_name.is_required")
    @DefaultValue("true")
    boolean isLastNameRequired();

    @Key("user.last_name.min_length")
    @DefaultValue("2")
    Integer lastNameMinLength();

    @Key("user.last_name.max_length")
    @DefaultValue("50")
    Integer lastNameMaxLength();

    @Key("user.age.min")
    @DefaultValue("18")
    Integer ageMin();

    @Key("user.age.max")
    @DefaultValue("60")
    Integer ageMax();

    @Key("user_profile.courses.max")
    @DefaultValue("10")
    Integer maxProfiles();

    @Key("user_profile.courses.max")
    @DefaultValue("50")
    Integer maxCourses();

    @Key("user_profile.experiences.max")
    @DefaultValue("50")
    Integer maxExperiences();

    @Key("user_profile.experiences.max")
    @DefaultValue("5")
    Integer maxEducations();

    // _________________________________________________________________________________________________________________

}
