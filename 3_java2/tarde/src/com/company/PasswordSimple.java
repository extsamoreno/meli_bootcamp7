package com.company;


public class PasswordSimple extends Password {

    private static final String PATTERN_SIMPLE = "^.{4,}";

    public PasswordSimple() {
        super(PATTERN_SIMPLE);
    }
}
