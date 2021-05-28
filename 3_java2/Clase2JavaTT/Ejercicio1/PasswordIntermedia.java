package com.company.Clase2JavaTT.Ejercicio1;

public class PasswordIntermedia extends Password{
    public PasswordIntermedia() {
        //Mínimo 8 caracteres con al menos una letra, un número y un caracter especial
        super("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
