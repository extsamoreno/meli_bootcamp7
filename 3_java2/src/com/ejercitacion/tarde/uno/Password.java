package com.ejercitacion.tarde.uno;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Password {

    protected String password;
    protected String regex;

    public Password(String regex) {
       this.regex = regex;
       this.password = "";
    }

    public Password() {
    }

    protected boolean validatePassword(String pass) {
        Pattern p = Pattern.compile(this.regex);
        Matcher m = p.matcher(pass);
        return m.matches();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordException {
        if (validatePassword(password)) {
            this.password = password;
        } else {
            throw new InvalidPasswordException("Invalid password");
        }
    }
}
