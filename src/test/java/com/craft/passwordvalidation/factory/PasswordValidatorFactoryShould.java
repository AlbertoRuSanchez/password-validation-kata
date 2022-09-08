package com.craft.passwordvalidation.factory;

import com.craft.passwordvalidation.factory.impl.PasswordValidatorEightCharsImpl;
import com.craft.passwordvalidation.factory.impl.PasswordValidatorSixCharsImpl;
import com.craft.passwordvalidation.factory.impl.PasswordValidatorSixteenCharsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PasswordValidatorFactoryShould {

    private PasswordValidatorFactory underTest;

    @BeforeEach
    void setUp() {
        underTest = new PasswordValidatorFactory();
    }

    @Test
    void return_PasswordValidatorSixCharsImpl() {
        //Given
        PasswordValidatorType typeSix = PasswordValidatorType.SIX_CHARS;

        //When
        PasswordValidator typeSixImpl = underTest.getPasswordValidator(typeSix);

        //Then
        assertThat(typeSixImpl).isNotNull();
        assertThat(typeSixImpl).isInstanceOf(PasswordValidatorSixCharsImpl.class);
    }

    @Test
    void return_PasswordValidatorEightCharsImpl() {
        //Given
        PasswordValidatorType typeEight = PasswordValidatorType.EIGHT_CHARS;

        //When
        PasswordValidator typeEightImpl = underTest.getPasswordValidator(typeEight);

        //Then
        assertThat(typeEightImpl).isNotNull();
        assertThat(typeEightImpl).isInstanceOf(PasswordValidatorEightCharsImpl.class);
    }

    @Test
    void return_PasswordValidatorSixteenCharsImpl() {
        //Given
        PasswordValidatorType typeSixteen = PasswordValidatorType.SIXTEEN_CHARS;

        //When
        PasswordValidator typeSixteenImpl = underTest.getPasswordValidator(typeSixteen);

        //Then
        assertThat(typeSixteenImpl).isNotNull();
        assertThat(typeSixteenImpl).isInstanceOf(PasswordValidatorSixteenCharsImpl.class);
    }

    @Test
    void throw_IlegalArgumentException_when_null_type_given() {
        //Given
        //When
        //Then
        assertThatThrownBy(() -> underTest.getPasswordValidator(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Null or wrong type of PasswordValidatorType");
    }
}
