package com.company;

public class PasswordIntermedia extends Password {

    private static final String PATTERN_INTERMEDIA = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";

    public PasswordIntermedia() {
        super(PATTERN_INTERMEDIA);
    }
}
