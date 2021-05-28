package com.meli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordSimple extends Password {
    private String password;

    public PasswordSimple(String password){
        setValue(password);
    }

    @Override
    public void setValue(String pwd) {
        Pattern pat = Pattern.compile("(?=.*[0-9])(?=.*[a-z]).{4,10}");
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
