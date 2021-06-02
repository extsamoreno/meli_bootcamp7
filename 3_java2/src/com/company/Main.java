package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        try{
            PasswordFuerte passwordFuerte = new PasswordFuerte("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
            setPassword(passwordFuerte);

            PasswordIntermedia passwordIntermedia = new PasswordIntermedia("^.*(?=.*[0-9])(?=.*[@#$%^&+=])(?=.*[a-z]).*$");
            setPassword(passwordIntermedia);

            PasswordSimple passwordSimple = new PasswordSimple("^.*(?=.*[0-9])(?=.*[a-z]).*$");
            setPassword(passwordSimple);


        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    private static void setPassword(Password password) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la contraseña: ");
        String pass = scanner.next();
        password.setValue(pass);
    }
}
