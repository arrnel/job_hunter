package com.jobhunter.helper;

public class StringHelper {

    public static boolean isNullOrEmpty(String text) {
        if (text == null) return true;
        return text.isEmpty();
    }

    public static boolean isNotNullOrEmpty(String text) {
        return !isNullOrEmpty(text);
    }

    public static boolean isNullOrBlank(String text) {
        if (text == null) return true;
        return text.isBlank();
    }

    public static boolean isNotNullOrBlank(String text) {
        return !isNullOrBlank(text);
    }

}
