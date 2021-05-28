package com.company.Clase2JavaTT.Ejercicio1;
import java.util.regex.*;

public class Password {
    private String value;
    private Pattern pattern;

    public Password(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public Password() {
        this.value = "";
    }

    public Password(Password password) {
        this.value = password.getValue();
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String password) throws IllegalArgumentException {
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();

        if(matchFound){
            this.value = password;
        } else {
            throw new IllegalArgumentException("Password Ivalida");
        }
    }
}
