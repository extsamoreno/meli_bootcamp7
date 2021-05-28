package com.company;

public class PasswordIntermedia extends Password{

    public PasswordIntermedia(String value) throws InstantiationException {
        //Minimo ocho caracteres, una letra, un numero, una mayuscula y una minuscula
        this.regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        this.value = value;
    }
}
