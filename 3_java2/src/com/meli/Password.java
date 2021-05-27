package com.meli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Password {
    private String pwd;

    public Password(String pwd){
        Pattern pat = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[–_.]).{8,20}");
        Matcher mat = pat.matcher(pwd);
        if(mat.matches())
            this.pwd = pwd;
        else
            System.out.println("Password NO Valido");
    }

}
