package com.company.CT.Ejercicio_1;

public class PasswordIntermedio extends Password{

    String Intermedia = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";

    public PasswordIntermedio(String passwd) {
        super();
        Password t = new Password(Intermedia);
        t.setValue(passwd);
        System.out.println("Contraseña Intermedia");
        t.validar();

    }
}
