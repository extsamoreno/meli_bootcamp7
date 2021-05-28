package com.meli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Password {
    private String password;

    public Password(String password){
        setValue(password);
    }

    public Password() {

    }

    public void setValue(String pwd) {
        Pattern pat = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[–_.]).{8,20}");
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
