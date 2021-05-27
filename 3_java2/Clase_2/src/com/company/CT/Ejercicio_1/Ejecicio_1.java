package com.company.CT.Ejercicio_1;

public class Ejecicio_1 {

    public static void main(String[] args) {

        Password arr[] = new Password[3];
        //La contraseña debe tener al entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula, al menos una mayúscula y al menos un caracter no alfanumérico.
        arr[0] = new PasswordFuerte("FH@123HolaMundo");

        //La contraseña debe tener al entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.
        //NO puede tener otros símbolos.

        arr[1] = new PasswordIntermedio("HOLAmundo2");

        //La contraseña debe tener al entre 1 y 10 caracteres, al menos un dígito, al menos una minúscula .
        //Puede tener otros símbolos.
        arr[2] = new PasswordSimple("hola9");


    }
}
