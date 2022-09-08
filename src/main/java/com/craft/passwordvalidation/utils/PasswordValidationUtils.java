package com.craft.passwordvalidation.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public final class PasswordValidationUtils {

    public static final String DIGIT_PATTERN = "\\d";
    public static final String LOWERCASE_PATTERN = "[a-z]";
    public static final String UPPERCASE_PATTERN = "[A-Z]";
    public static final String UNDERSCORE_PATTERN = "_";

    private PasswordValidationUtils() {}

    private static boolean checkIfContainsPattern(String value, String pattern) {

        if(Objects.isNull(value)){
            return false;
        }

        return Pattern.compile(pattern)
                .matcher(value)
                .find();
    }

    public static boolean checkIfContainsDigit(String value){
        return checkIfContainsPattern(value, DIGIT_PATTERN);
    }

    public static boolean checkIfContainsUpperCase(String value){
        return checkIfContainsPattern(value, UPPERCASE_PATTERN);
    }

    public static boolean checkIfContainsLowerCase(String value) {
        return checkIfContainsPattern(value, LOWERCASE_PATTERN);
    }

    public static boolean checkIfContainsUnderScore(String value) {
        return checkIfContainsPattern(value, UNDERSCORE_PATTERN);
    }

    public static boolean checkIfValueHasCorrectLength(String value, int length){
        return !StringUtils.isEmpty(value) && value.length() >= length;
    }
}
