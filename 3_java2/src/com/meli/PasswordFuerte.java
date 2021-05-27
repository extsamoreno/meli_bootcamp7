package com.meli;

public class PasswordFuerte extends password {

    private final String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public PasswordFuerte() {
        super();
        this.setRegex(this.REGEX);
    }

}