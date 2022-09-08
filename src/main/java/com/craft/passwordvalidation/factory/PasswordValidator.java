package com.craft.passwordvalidation.factory;

import com.craft.passwordvalidation.ValidationErrorType;

import java.util.List;

public interface PasswordValidator {

    Integer MAX_NUMBER_OF_ERRORS = 2;
    default boolean isValidPassword(String password) {
        return returnPasswordErrors(password).size() < MAX_NUMBER_OF_ERRORS;
    }
    List<ValidationErrorType> returnPasswordErrors(String password);
}
