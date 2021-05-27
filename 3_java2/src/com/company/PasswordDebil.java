package com.company;

public class PasswordDebil extends Password{

    public PasswordDebil(String value) throws InstantiationException {
        this.regex = "";
        this.value = value;
        this.testRegex(this.regex);
    }
}
