package com.github.vasiliz.rocketswheel.utils;

public class  StringUtils {

    public static String replaceTag(String text){
     String result = text.replace("<br>", "\n");
     return result;
    }

}
