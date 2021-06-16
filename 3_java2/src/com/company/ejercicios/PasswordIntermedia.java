package com.company.ejercicios;

public class PasswordIntermedia extends Password{

    final String REGEX = "^(?=.*[0-9])(?=.*[a-z]).{8,20}$";

    public PasswordIntermedia(String value){
        super();
        this.setRegex(REGEX);
    }
}
