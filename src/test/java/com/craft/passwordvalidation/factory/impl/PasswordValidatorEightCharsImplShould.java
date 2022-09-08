package com.craft.passwordvalidation.factory.impl;

import com.craft.passwordvalidation.ValidationErrorType;
import com.craft.passwordvalidation.factory.PasswordValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidatorEightCharsImplShould {

    private PasswordValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PasswordValidatorEightCharsImpl();
    }

    @ParameterizedTest
    //Given
    @CsvSource({"Er444_6gCxg,true", "wrong,false", "DSAdasd8d_fF4,true", "55jj,false" ,
            "DSAdasd8@_fF4,true"," ,false", "sSdA3_,true"})
    void validate_password(String password, Boolean expectedResponse) {
        //When
        boolean isValidPassword = underTest.isValidPassword(password);

        //Then
        assertThat(isValidPassword).isEqualTo(expectedResponse);
    }

    @Test
    void return_an_empty_list_of_ValidationErrorType_when_password_is_correct() {
        //Given
        String password = "Er444_6gCxg";

        //When
        List<ValidationErrorType> listOfErrors = underTest.returnPasswordErrors(password);

        //Then
        assertThat(listOfErrors).isNotNull().isEmpty();
    }

    @Test
    void return_a_list_of_ValidationErrorType_found_while_validating_password(){

        //Given
        String passwordWithErrors = "";

        //When
        List<ValidationErrorType> listOfErrors = underTest.returnPasswordErrors(passwordWithErrors);

        //Then
        assertThat(listOfErrors).isNotNull();
        assertThat(listOfErrors.isEmpty()).isFalse();
        assertThat(listOfErrors).contains(ValidationErrorType.MUST_HAVE_UNDERSCORE);
        assertThat(listOfErrors).contains(ValidationErrorType.MUST_HAVE_MORE_THAN);
        assertThat(listOfErrors).contains(ValidationErrorType.MUST_HAVE_UPPER_CASE);
        assertThat(listOfErrors).contains(ValidationErrorType.MUST_HAVE_LOWER_CASE);

    }



}
