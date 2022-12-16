package com.gokalp.casgembootcamp.gen.enums;

/**
 * @author Gokalp on 16.12.2022
 * @project casgem-bootcamp
 */
public enum ValidationErrorMessage implements BaseErrorMessage{
    ConfirmPasswordValid("Confirm password must be same with password")
    ;

    private String message;

    ValidationErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
