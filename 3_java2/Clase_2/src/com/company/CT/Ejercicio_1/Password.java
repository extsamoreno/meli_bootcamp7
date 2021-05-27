package com.company.CT.Ejercicio_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public String Regex="";
    public String pwd="";

    public Password(String regex) {
        this.Regex = regex;
    }

    public Password(){
    }
    public void validar() {
        Pattern r = Pattern.compile(this.Regex);
        Matcher m = r.matcher(pwd);
        if(m.matches()){
            System.out.println("La contraseña es valida");
        }else{
            System.out.println("La contraseña es invalida");
        }
    }


    public void setValue(String pwd){
        this.pwd=pwd;
    };

}
