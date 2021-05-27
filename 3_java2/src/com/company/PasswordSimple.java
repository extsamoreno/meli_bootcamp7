package com.company;

public class PasswordSimple extends Password{

    public PasswordSimple(){

        super("^.*(?=.*[A-Za-z]).{4,}");
    }
}
