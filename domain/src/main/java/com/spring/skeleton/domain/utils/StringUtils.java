package com.spring.skeleton.domain.utils;

public class StringUtils {
    public static boolean isEmptyOrNull(String string) {
        return string == null || string.isEmpty();
    }

    private StringUtils() {}
}
