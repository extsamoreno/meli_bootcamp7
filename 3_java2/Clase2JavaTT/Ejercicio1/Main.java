package com.company.Clase2JavaTT.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Password password = new Password("hola");
        try {
            password.setValue("");
            System.out.println("Password válida");
        } catch (IllegalArgumentException ex) {
            System.out.println("Password inválida");
        }

        PasswordSimple passwordSimple = new PasswordSimple();
        try {
            passwordSimple.setValue("gdfte85hj");
            System.out.println("Password válida");
        } catch (IllegalArgumentException ex) {
            System.out.println("Password inválida");
        }

        PasswordIntermedia passwordIntermedia = new PasswordIntermedia();
        try {
            passwordIntermedia.setValue("ghtgf89$%");
            System.out.println("Password válida");
        } catch (IllegalArgumentException ex) {
            System.out.println("Password inválida");
        }

        PasswordFuerte passwordFuerte= new PasswordFuerte();
        try {
            passwordFuerte.setValue("jhIU56?!");
            System.out.println("Password válida");
        } catch (IllegalArgumentException ex) {
            System.out.println("Password inválida");
        }

    }
}
