package com.company;

public class PasswordSimple extends Password{
    // String Simple = "(.*[a-z])(.*[0-9])";
    String Simple = "^(?=\\w*\\d)(?=\\w*[a-z])\\S{1,10}$";

    public PasswordSimple(String passwd) {
        super();
        Password t = new Password(Simple);
        t.setValue(passwd);
        System.out.println("Contraseña Simple");
        t.validar();

    }
}
