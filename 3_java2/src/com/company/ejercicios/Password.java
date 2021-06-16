package com.company.ejercicios;

public class Password {

    public String value;
    public String regex;

    public Password(String regex){
        this.regex = regex;
    }



    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Password(){

    }

    public String getValue() {
        return value;
    }

    public void setValue(String pwd) throws Exception {
        String msg = "Passwords do not match";
        if(pwd.matches(this.regex)){
            this.value = pwd;
        } else {
            throw new Exception(msg);
        }
    }
}
