package com.company.ejercicios;

public class PasswordFuerte extends Password{

    final String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public PasswordFuerte(String value){
        super();
        this.setRegex(REGEX);
    }
}
