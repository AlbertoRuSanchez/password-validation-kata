package com.craft.passwordvalidation.factory.impl;

import com.craft.passwordvalidation.ValidationErrorType;
import com.craft.passwordvalidation.utils.PasswordValidationUtils;
import com.craft.passwordvalidation.factory.PasswordValidator;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidatorEightCharsImpl implements PasswordValidator {

    private static final int MIN_NUMBER_OF_CHARS = 8;

    public boolean isValidPassword(String password) {
        return returnPasswordErrors(password).size() < 2;
    }

    @Override
    public List<ValidationErrorType> returnPasswordErrors(String password) {

        List<ValidationErrorType> listOfErrors = new ArrayList<>();

        if(!PasswordValidationUtils.checkIfValueHasCorrectLength(password, MIN_NUMBER_OF_CHARS)){
            listOfErrors.add(ValidationErrorType.MUST_HAVE_MORE_THAN);
        }

        if(!PasswordValidationUtils.checkIfContainsDigit(password)){
            listOfErrors.add(ValidationErrorType.MUST_HAVE_DIGITS);
        }

        if(!PasswordValidationUtils.checkIfContainsUpperCase(password)){
            listOfErrors.add(ValidationErrorType.MUST_HAVE_UPPER_CASE);
        }

        if(!PasswordValidationUtils.checkIfContainsLowerCase(password)){
            listOfErrors.add(ValidationErrorType.MUST_HAVE_LOWER_CASE);
        }

        if(!PasswordValidationUtils.checkIfContainsUnderScore(password)){
            listOfErrors.add(ValidationErrorType.MUST_HAVE_UNDERSCORE);
        }

        return listOfErrors;
    }

}
