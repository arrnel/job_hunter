package com.jobhunter.helper;

public class StringHelper {

    public static boolean isEmptyOrBlank(String text){
        if(text == null) return true;
        return text.isBlank();
    }

}
