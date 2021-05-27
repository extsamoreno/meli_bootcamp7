package com.ejercitacion.tarde.uno;

public class PasswordFuerte extends Password {

    public PasswordFuerte() {
        super("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

}
