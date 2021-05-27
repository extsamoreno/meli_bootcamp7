package com.company.ej1Tarde;

public class PasswordIntermedia extends Password {

    private final String REGEX = "^(?=.*[0-9])(?=.*[a-z]).{8,20}$";

    public PasswordIntermedia() {
        super();
        this.setRegex(this.REGEX);
    }

}
