package com.craft.passwordvalidation;

public enum ValidationErrorType {

    MUST_HAVE_MORE_THAN("The password is too short"),
    MUST_HAVE_UPPER_CASE("The password must have at least an upper case"),
    MUST_HAVE_LOWER_CASE("The password must have at least a lower case"),
    MUST_HAVE_DIGITS("The password must have at a number"),
    MUST_HAVE_UNDERSCORE("The password must have at least an underscore");

    private final String description;

    ValidationErrorType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
