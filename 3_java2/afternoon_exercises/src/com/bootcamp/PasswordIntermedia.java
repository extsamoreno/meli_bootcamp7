package com.bootcamp;

public class PasswordIntermedia extends Password {

    //Minimum eight characters, at least one letter, one number and one special character
    public static final String REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";

    public PasswordIntermedia() {
        super(REGEX);
    }
}
