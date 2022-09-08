package com.craft.passwordvalidation.factory;

import com.craft.passwordvalidation.factory.impl.PasswordValidatorEightCharsImpl;
import com.craft.passwordvalidation.factory.impl.PasswordValidatorSixCharsImpl;
import com.craft.passwordvalidation.factory.impl.PasswordValidatorSixteenCharsImpl;

public class PasswordValidatorFactory {
    public PasswordValidator getPasswordValidator(PasswordValidatorType type) {
        try {
            switch (type) {
                case SIX_CHARS:
                    return new PasswordValidatorSixCharsImpl();
                case EIGHT_CHARS:
                    return new PasswordValidatorEightCharsImpl();
                case SIXTEEN_CHARS:
                    return new PasswordValidatorSixteenCharsImpl();
                default: return null;
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Null or wrong type of PasswordValidatorType");
        }
    }
}
