package com.meli;

public class PasswordSimple extends Password {
    //Minimum eight characters, at least one letter and one number
    public PasswordSimple() {
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }
}
