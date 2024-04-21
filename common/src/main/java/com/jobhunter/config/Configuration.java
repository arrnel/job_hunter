package com.jobhunter.config;

import org.aeonbits.owner.Config;

public interface Configuration extends Config {

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

    // INFO: jobHunter-cv
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

    // INFO: jobHunter-notification
    // _________________________________________________________________________________________________________________

    // INFO: jobHunter-user
    @Key("user.username.min_length")
    @DefaultValue("4")
    int usernameMinLength();

    @Key("user.username.max_length")
    @DefaultValue("50")
    int usernameMaxLength();

    @Key("user.email.min_length")
    @DefaultValue("9")
    int emailMinLength();

    @Key("user.email.max_length")
    @DefaultValue("50")
    int emailMaxLength();

    @Key("user.password.min_length")
    @DefaultValue("8")
    int passwordMinLength();

    @Key("user.password.max_length")
    @DefaultValue("50")
    int passwordMaxLength();

    @Key("user.first_name.min_length")
    @DefaultValue("2")
    int firstNameMinLength();

    @Key("user.first_name.max_length")
    @DefaultValue("50")
    int firstNameMaxLength();

    @Key("user.last_name.is_required")
    @DefaultValue("true")
    boolean isLastNameRequired();

    @Key("user.last_name.min_length")
    @DefaultValue("2")
    int lastNameMinLength();

    @Key("user.last_name.max_length")
    @DefaultValue("50")
    int lastNameMaxLength();

    @Key("user.age.min")
    @DefaultValue("18")
    int ageMin();

    @Key("user.age.max")
    @DefaultValue("60")
    int ageMax();
    // _________________________________________________________________________________________________________________

    // INFO: jobHunter-vacancy

}
