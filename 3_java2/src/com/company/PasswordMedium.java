package com.company;

public class PasswordMedium extends Password{

    public PasswordMedium(){
        super("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}");
    }
}