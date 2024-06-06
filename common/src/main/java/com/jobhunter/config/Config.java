package com.jobhunter.config;

import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;

public class Config {

    private static Configuration config = ConfigFactory.create(Configuration.class, System.getProperties());

    public static void reload() {
        config = ConfigFactory.create(Configuration.class, System.getProperties());
    }

    public static class Port {

        public static Integer auth() {
            return config.jobHunterAuthPort();
        }

        public static Integer comments() {
            return config.jobHunterCommentsPort();
        }

        public static Integer company() {
            return config.jobHunterCompanyPort();
        }

        public static Integer currency() {
            return config.jobHunterCurrencyPort();
        }

        public static Integer userProfile() {
            return config.jobHunterUserProfilePort();
        }

        public static Integer files() {
            return config.jobHunterFilesPort();
        }

        public static Integer frontend() {
            return config.jobHunterFrontPort();
        }

        public static Integer gateway() {
            return config.jobHunterGatewayPort();
        }

        public static Integer geo() {
            return config.jobHunterGeoPort();
        }

        public static Integer job() {
            return config.jobHunterJobPort();
        }

        public static Integer notification() {
            return config.jobHunterNotificationPort();
        }

        public static Integer user() {
            return config.jobHunterUserPort();
        }

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

//    All in user
//    public static class UserProfile {}

    public static class Files {

    }

    public static class Frontend {

    }


    public static class Geo {
        public static String simpleMapsFileVersion() {
            return config.geoFileVersion();
        }
    }

    public static class Job {

        public static String pathToCategoriesFile() {
            return config.pathToCategoriesFile();
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

        public static int profilesMax() {
            return config.maxProfiles();
        }

        public static int experiencesMax() {
            return config.maxExperiences();
        }

        public static int coursesMax() {
            return config.maxCourses();
        }

        public static int educationsMax() {
            return config.maxEducations();
        }


    }

}