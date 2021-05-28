package com.bootcamp;

public class PasswordFuerte extends Password {

    //Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
    public static final String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public PasswordFuerte() {
        super(REGEX);
    }
}