package com.company;

public class PasswordIntermedia extends Password{

    public PasswordIntermedia(String value) throws InstantiationException {
        this.regex = "";
        this.value = value;
        this.testRegex(this.regex);
    }
}
