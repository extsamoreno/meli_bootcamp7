package com.meli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordIntermedia extends Password{
    private String password;

    public PasswordIntermedia(String password){
        setValue(password);
    }

    @Override
    public void setValue(String pwd) {
        Pattern pat = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%]{8,14}");
        Matcher mat = pat.matcher(pwd);
        if(mat.matches()) {
            this.password = pwd;
        }
        else {
            Exception exe = new IllegalArgumentException("Contraseña Introducida No Valida");
            exe.printStackTrace();
        }
    }
}
