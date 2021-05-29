package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordFuerte  extends Password{

    public PasswordFuerte(String regExp) throws Exception {
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}$");
    }
}
