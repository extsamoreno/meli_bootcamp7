package com.company;

public class PasswordSimple extends Password{

    public PasswordSimple(String value) throws InstantiationException {
        this.regex = "";
        this.value = value;
        this.testRegex(this.regex);
    }
}
