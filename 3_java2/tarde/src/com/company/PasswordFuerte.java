package com.company;

public class PasswordFuerte extends Password {

    private static final String PATTERN_FUERTE = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public PasswordFuerte() {
        super(PATTERN_FUERTE);
    }
}