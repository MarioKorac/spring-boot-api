package com.mario.api.errors;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Required fields missing,check docs"),
    RECORD_ALREADY_EXIST("Record already exist!"),
    LIST_IS_EMPTY("DB doesnt contains any records!"),
    RECORD_DOES_NOT_EXIST("Record doesnt exist!"),
    BAD_TOKEN_REQUEST("Username and password required"),
    TOKEN_IS_NOT_VALID("Token is not valid!");



    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
