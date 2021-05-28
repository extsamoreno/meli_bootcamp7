package com.company;

public class PasswordSimple extends Password{

    public PasswordSimple(String value) {
        //Minimo ocho caracteres, una letra, un numero y un caracter especial
        this.regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        this.value = value;
    }
}
