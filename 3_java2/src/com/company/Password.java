package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String password;
    private String regExp;

    public Password(String regExp){
        this.regExp = regExp;
    }

    public void setPassword(String password) throws IllegalArgumentException{
        Pattern pat = Pattern.compile(this.regExp);
        Matcher mat = pat.matcher(password);

        if (mat.matches()) {
            this.password = password;
        }else {
            throw new IllegalArgumentException("Password not valid");
        }
    }

    public String getPassword(){
        return password;
    }


    }

