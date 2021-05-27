package com.company;

import jdk.jshell.EvalException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String pass;
    private String password_pattern;

    public Password(String pass_pattern) {
        this.password_pattern = pass_pattern;
    }

    public void setValue(String password) throws Exception {
        Pattern pattern = Pattern.compile(this.password_pattern);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            this.pass = password;
        } else {
            throw new Exception("Password no cumple requisitos");
        }
    }
}
