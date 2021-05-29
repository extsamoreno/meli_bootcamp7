package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordDebil  extends Password{

    public PasswordDebil(String regExp) {
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{3,6}$");
    }
}
