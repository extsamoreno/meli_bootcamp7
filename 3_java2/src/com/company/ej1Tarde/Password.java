package com.company.ej1Tarde;

public class Password {

    private String value;
    private String regex;

    public Password(String regex) {
        this.regex = regex;
    }

    public Password() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) throws Exception {
        if(value.matches(this.regex)) {
            this.value = value;
        } else {
            throw new Exception("Password doesn't match regex.");
        }
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

}
