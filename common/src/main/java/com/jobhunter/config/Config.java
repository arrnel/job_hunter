package com.jobhunter.config;

import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;

public class Config {

    private static Configuration config = ConfigFactory.create(Configuration.class, System.getProperties());

    public static void reload() {
        config = ConfigFactory.create(Configuration.class, System.getProperties());
    }

    public static class Auth {

    }

    public static class Comments {

    }

    public static class Company {

    }

    public static class Currency {

        public static String defaultCurrency() {
            return config.defaultCurrency().toUpperCase();
        }

        public static String[] activeCurrencies() {
            return Arrays.stream(config.activeCurrencies()).map(String::toUpperCase).toArray(String[]::new);
        }

    }

    public static class CV {

    }

    public static class Files {

    }

    public static class Frontend {

    }


    public static class Geo {
        public static String simpleMapsFileVersion() {
            return config.geoFileVersion();
        }
    }


    public static class Notification {

    }

    public static class User {
        public static int usernameMinLength() {
            return config.usernameMinLength();
        }

        public static int usernameMaxLength() {
            return config.usernameMaxLength();
        }

        public static int emailMinLength() {
            return config.emailMinLength();
        }

        public static int emailMaxLength() {
            return config.emailMaxLength();
        }

        public static int passwordMinLength() {
            return config.passwordMinLength();
        }

        public static int passwordMaxLength() {
            return config.passwordMaxLength();
        }

        public static int firstNameMinLength() {
            return config.firstNameMinLength();
        }

        public static int firstNameMaxLength() {
            return config.firstNameMaxLength();
        }

        public static boolean isLastNameRequired() {
            return config.isLastNameRequired();
        }

        public static int lastNameMinLength() {
            return config.lastNameMinLength();
        }

        public static int lastNameMaxLength() {
            return config.lastNameMaxLength();
        }

        public static int ageMin() {
            return config.ageMin();
        }

        public static int ageMax() {
            return config.ageMax();
        }
    }

    public static class Vacancy {

    }

}