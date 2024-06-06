package com.jobhunter.helper;

import java.math.BigDecimal;

public class NumbersHelper {

    public static <T> boolean isNullOrZero(T value) {
        if (value == null) return true;
        if (!(value instanceof Number))
            throw new IllegalArgumentException("Invalid argument type or value: [" + value + "]");
        return new BigDecimal(value.toString()).compareTo(BigDecimal.ZERO) == 0;
    }

    public static <T> boolean isNotNullOrZero(T value) {
        return !isNullOrZero(value);
    }


    public static <T> boolean isParsable(String value) {

        if (StringHelper.isNullOrBlank(value)) return false;
        if (value.charAt(value.length() - 1) == '.' || value.charAt(0) == '.') return false;
        if (value.charAt(0) == '-') {
            if (value.length() == 1) return false;
            return withDecimalsParsing(value, 1);
        }
        return withDecimalsParsing(value, 0);
    }

    private static boolean withDecimalsParsing(final String str, final int beginIdx) {

        int decimalPoints = 0;

        for (int i = beginIdx; i < str.length(); i++) {
            final char ch = str.charAt(i);
            final boolean isDecimalPoint = ch == '.';
            if (isDecimalPoint) decimalPoints++;
            if (decimalPoints > 1) return false;
            if (!isDecimalPoint && !Character.isDigit(ch)) return false;
        }

        return true;

    }


}
