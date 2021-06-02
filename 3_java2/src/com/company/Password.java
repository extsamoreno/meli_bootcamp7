package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String password;
    private String regex;

    public Password(String regex) {
        this.regex = regex;
    }

    public void setValue(String password) throws Exception{
        Pattern pattern = Pattern.compile(this.regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            this.password = password;
            System.out.println("Contraseña generada correctamente");
        }
        else{
            throw new Exception("La contraseña no cumple los requerimientos.");
        }
    }


}