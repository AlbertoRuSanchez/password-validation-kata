package com.craft.passwordvalidation;

import com.craft.passwordvalidation.factory.PasswordValidator;
import com.craft.passwordvalidation.factory.PasswordValidatorFactory;
import com.craft.passwordvalidation.factory.PasswordValidatorType;

public class MainApplication {
    public static void main(String[] args) {

        PasswordValidatorFactory factory = new PasswordValidatorFactory();

        printLine("-- Six type password validator --");
        String wrongPw = "dfff";
        String validPw = "dFd4h_3sf";
        PasswordValidator passwordValidatorTypeSix = factory.getPasswordValidator(PasswordValidatorType.SIX_CHARS);
        printLine(wrongPw + " --->" + passwordValidatorTypeSix.isValidPassword(wrongPw));
        printLine(validPw + " --->" + passwordValidatorTypeSix.isValidPassword(validPw));
        printLine("");


        printLine("-- Eight type password validator --");
        wrongPw = "dsaHjY5";
        validPw = "dsaHjY5_dfadg4";
        PasswordValidator passwordValidatorTypeEight = factory.getPasswordValidator(PasswordValidatorType.EIGHT_CHARS);
        printLine(wrongPw + " --->" + passwordValidatorTypeEight.isValidPassword(wrongPw));
        printLine(validPw + " --->" + passwordValidatorTypeEight.isValidPassword(validPw));
        printLine("");

        printLine("-- SixTeen type password validator --");
        wrongPw = "hdfgldmgf4fd_";
        validPw = "hdfgldmgf4fd_fGd335_s";
        PasswordValidator passwordValidatorTypeSixTeen = factory.getPasswordValidator(PasswordValidatorType.SIXTEEN_CHARS);
        printLine(wrongPw + " --->" + passwordValidatorTypeSixTeen.isValidPassword(wrongPw));
        printLine(validPw + " --->" + passwordValidatorTypeSixTeen.isValidPassword(validPw));

    }

    private static void printLine(Object valueToPrint) {
        System.out.println(valueToPrint);
    }
}
