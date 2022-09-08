package com.craft.passwordvalidation.factory.impl;

import com.craft.passwordvalidation.ValidationErrorType;
import com.craft.passwordvalidation.factory.PasswordValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidatorSixteenCharsImplShould {

    private PasswordValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PasswordValidatorSixteenCharsImpl();
    }

    @ParameterizedTest
    //Given
    @CsvSource({"Er444_6gCxsasSDasdg,true", "6gCxgsds3sdasds_ad2f,true", "6gCxf,false", "3333AAA,false"
            , "3333aaa,false", "aaaaaaaaa,false"})
    void validate_password(String password, Boolean expectedResponse) {
        //When
        boolean isValidPassword = underTest.isValidPassword(password);

        //Then
        assertThat(isValidPassword).isEqualTo(expectedResponse);
    }

    @Test
    void should_return_empty_list_if_password_is_correct() {
        //Given
        String correctPassword = "Er444_6gCxsasSDasdg";

        //When
        List<ValidationErrorType> listOfErrors = underTest.returnPasswordErrors(correctPassword);

        //Then
        assertThat(listOfErrors).isNotNull().isEmpty();
    }

    @Test
    void should_return_list_of_errors_found_in_wrong_password() {
        //Given
        String wrongPassword = "";

        //When
        List<ValidationErrorType> listOfErrors = underTest.returnPasswordErrors(wrongPassword);

        //Then
        assertThat(listOfErrors)
                .isNotNull()
                .isNotEmpty();

        assertThat(listOfErrors)
                .contains(ValidationErrorType.MUST_HAVE_LOWER_CASE)
                .contains(ValidationErrorType.MUST_HAVE_MORE_THAN)
                .contains(ValidationErrorType.MUST_HAVE_UPPER_CASE)
                .contains(ValidationErrorType.MUST_HAVE_DIGITS);

    }

}
