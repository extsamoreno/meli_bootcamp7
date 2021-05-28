package com.bootcamp;

public class PasswordSimple extends Password {

    //Minimum eight characters, at least one letter and one number
    public static final String REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    public PasswordSimple() {
        super(REGEX);
    }
}
