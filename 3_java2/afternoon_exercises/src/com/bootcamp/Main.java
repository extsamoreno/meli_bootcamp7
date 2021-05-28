package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        Password pswd = new Password("hola");

        try {
            pswd.setValue("hola");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        PasswordFuerte strong = new PasswordFuerte();

        try {
            strong.setValue("Ho?5asds");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        PasswordIntermedia medium = new PasswordIntermedia();

        try {
            medium.setValue("a1%asdert");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        PasswordSimple weak = new PasswordSimple();

        try {
            weak.setValue("asdf1234");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        FiguraGeometrica arr[] = new FiguraGeometrica[3];
        arr[0] = new Circulo(5);
        arr[1] = new Triangulo(8,2);
        arr[2] = new Rectangulo(3,7);

        double areaPromedio = FiguraGeometricaUtil.areaPromedio(arr);
        System.out.println(areaPromedio);
    }


}
