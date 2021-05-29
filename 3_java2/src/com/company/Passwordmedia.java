package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passwordmedia extends Password{

    public Passwordmedia(String regExp) {
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,10}$");
    }
}
