package com.company.Clase2JavaTT.Ejercicio1;

public class PasswordFuerte extends Password{
    public PasswordFuerte() {
        //Minimo 8 y máximo 10 caracteres con al menos una letra mayúscula, una minúscula, un número y un caracter especial
        super("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$");
    }
}
