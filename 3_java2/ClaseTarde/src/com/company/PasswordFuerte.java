package com.company;

public class PasswordFuerte extends Password{
    //String Fuerte = "(.*[a-z])(.*[0-9])(.*[@#$%^&+=])(.*[A-Z])";
    String Fuerte = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$";
    //
    public PasswordFuerte(String passwd) {
        super();
        Password t = new Password(Fuerte);
        t.setValue(passwd);
        System.out.println("Contraseña fuerte");
        t.validar();
    }
}
