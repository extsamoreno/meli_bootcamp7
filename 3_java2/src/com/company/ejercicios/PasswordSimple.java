package com.company.ejercicios;

public class PasswordSimple extends Password{
    final String REGEX = "^(?=.*[a-z]).{8,20}$";

    public PasswordSimple(String value){
        super();
        this.setRegex(REGEX);
    }
}
