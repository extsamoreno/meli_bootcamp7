package com.company.ej1Tarde;

public class PasswordSimple extends Password {

    private final String REGEX = "^(?=.*[a-z]).{1,20}$";

    public PasswordSimple() {
        super();
        this.setRegex(this.REGEX);
    }

}
