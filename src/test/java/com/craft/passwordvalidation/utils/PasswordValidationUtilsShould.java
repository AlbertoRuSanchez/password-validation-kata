package com.craft.passwordvalidation.utils;

import com.craft.passwordvalidation.utils.PasswordValidationUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidationUtilsShould {

    @ParameterizedTest
    //Given
    @CsvSource({
            "dAs3d4Ggd_hhhds,true",
            "skdDAdasdfgas,false"
    })
    void validate_if_given_string_has_digits(String value, boolean expectedValue) {

        //When
        boolean patternFound = PasswordValidationUtils.checkIfContainsDigit(value);

        //Then
        assertThat(patternFound).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    //Given
    @CsvSource({
            "dAs3d4Ggd_hhhds,true",
            "skdDAdasdfgas,true",
            "sssdasdghjyjfhfg,false",
            "fff,false"
    })
    void validate_if_given_string_has_at_least_an_upper_case(String value, boolean expectedValue) {

        //When
        boolean patternFound = PasswordValidationUtils.checkIfContainsUpperCase(value);

        //Then
        assertThat(patternFound).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    //Given
    @CsvSource({
            "dAs3d4Ggd_hhhds,true",
            "skdDAdasdfgas,true",
            "DSADIOP4FSMDKSDF,false",
            "FFFFFF,false"
    })
    void validate_if_given_string_has_at_least_a_lower_case(String value, boolean expectedValue) {

        //When
        boolean patternFound = PasswordValidationUtils.checkIfContainsLowerCase(value);

        //Then
        assertThat(patternFound).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    //Given
    @CsvSource({
            "dAs3d4Ggd_hhhds,true",
            "skdDAdasdfgas,false",
            "DSADIOP4FSMDKSDF,false",
            "FFFFFF,false",
            "sdd_Ss4d_df,true",
            "_,true"
    })
    void validate_if_given_string_has_at_least_an_underscore(String value, boolean expectedValue) {

        //When
        boolean patternFound = PasswordValidationUtils.checkIfContainsUnderScore(value);

        //Then
        assertThat(patternFound).isEqualTo(expectedValue);
    }

}
