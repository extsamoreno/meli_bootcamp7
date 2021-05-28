package com.company;

import figurasGeometricas.Circulo;
import figurasGeometricas.FiguraGeometrica;
import figurasGeometricas.Rectangulo;
import figurasGeometricas.Triangulo;
import password.Password;
import password.PasswordFuerte;
import password.PasswordIntermedia;
import password.PasswordSimple;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Fraccion fr1 = new Fraccion(4, 5);
        Fraccion fr2 = new Fraccion(6, 8);
        Fraccion rtdo = fr1.sumar(fr2);
        Fraccion rtdo1 = fr1.dividir(3);
        Fraccion rtdo3 = fr1.multiplicar(fr2);
        Fraccion rtdo4 = fr1.dividir(fr2);
        System.out.println(rtdo.getNumerador() + "/" + rtdo.getDenominador());
        System.out.println(rtdo1.getNumerador() + "/" + rtdo1.getDenominador());
        System.out.println(rtdo3.getNumerador() + "/" + rtdo3.getDenominador());
        System.out.println(rtdo4.getNumerador() + "/" + rtdo4.getDenominador());

        Password password = new PasswordFuerte();

        try {
            password.setPassword("2423adasdQasdq.comsdQ");
            System.out.println(password.getPassword());
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalido");
        }

        FiguraGeometrica figura1 = new Circulo(5);
        FiguraGeometrica figura2 = new Rectangulo(4, 10);
        FiguraGeometrica figura3 = new Triangulo(12, 6);

        FiguraGeometrica[] figuras = {figura1, figura2, figura3};

        double result = FiguraGeometrica.areaPromedio(figuras);

        System.out.println(result);
    }
}
