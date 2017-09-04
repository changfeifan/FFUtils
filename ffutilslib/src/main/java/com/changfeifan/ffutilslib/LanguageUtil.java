package com.changfeifan.ffutilslib;

import java.util.Locale;

/**
 * Created by changfeifan on 2017/3/6.
 */

public class LanguageUtil {

    /**
     * check Language
     * if language is UK or US return false
     * else
     *
     * @return false
     */
    public static boolean checkLanguage() {
        Locale locale = Locale.getDefault();
        if (locale.getDisplayLanguage().equals("English")) {
            return true;
        } else return false;
    }
}
