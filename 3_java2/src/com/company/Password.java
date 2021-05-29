package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String password;

    public Password(String password){
        //Pattern pat = Pattern.compile("(?=.*[a-z])");
        //Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // Pattern pat = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$\"");
        Pattern pat = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[–_.]).{8,20}");
        Matcher mat = pat.matcher(password);

        if(mat.matches()){
            this.password = password;
            System.out.println("valido");

        }else{
            System.out.println("invalido");
        }
    }
}
