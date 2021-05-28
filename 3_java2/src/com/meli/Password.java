package com.meli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Password {
    private String password;

    public Password(String password){
        Pattern pat = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[–_.]).{8,20}");
        Matcher mat = pat.matcher(password);
        if(mat.matches()) {
            this.password = password;
            System.out.println("Pasword Valida");
        }
        else {
            System.out.println("Password NO Valido");
        }
    }

}
