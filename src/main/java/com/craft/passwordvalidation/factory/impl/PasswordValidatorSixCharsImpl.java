package com.craft.passwordvalidation.factory.impl;

import com.craft.passwordvalidation.ValidationErrorType;
import com.craft.passwordvalidation.factory.PasswordValidator;
import com.craft.passwordvalidation.utils.PasswordValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidatorSixCharsImpl implements PasswordValidator {

    public static final int MIN_NUMBER_OF_CHARS = 6;

    @Override
    public List<ValidationErrorType> returnPasswordErrors(String password) {

        List<ValidationErrorType> listOfErrors = new ArrayList<>();

        if(!PasswordValidationUtils.checkIfValueHasCorrectLength(password, MIN_NUMBER_OF_CHARS)){
            listOfErrors.add(ValidationErrorType.MUST_HAVE_MORE_THAN);
        }

        if(!PasswordValidationUtils.checkIfContainsDigit(password)){
            listOfErrors.add(ValidationErrorType.MUST_HAVE_DIGITS);
        }

        if(!PasswordValidationUtils.checkIfContainsLowerCase(password)){
            listOfErrors.add(ValidationErrorType.MUST_HAVE_LOWER_CASE);
        }

        if(!PasswordValidationUtils.checkIfContainsUpperCase(password)){
            listOfErrors.add(ValidationErrorType.MUST_HAVE_UPPER_CASE);
        }

        return listOfErrors;
    }
}
