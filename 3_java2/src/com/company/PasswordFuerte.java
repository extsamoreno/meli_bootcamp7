package com.company;

public class PasswordFuerte extends Password{

    public PasswordFuerte(String value) throws InstantiationException {
        //Minimo ocho caracteres, al menos una mayuscula, una minuscula un numero y un caracter especial
        this.regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        this.value = value;
    }
}
