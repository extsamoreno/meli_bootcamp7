package com.meli;

public class PasswordSimple extends password {

    private final String REGEX = "^(?=.*[a-z]).{1,20}$";

    public PasswordSimple() {
        super();
        this.setRegex(this.REGEX);
    }

}