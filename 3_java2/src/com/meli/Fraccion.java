package com.meli;

import javax.xml.stream.FactoryConfigurationError;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int numerador) {
        this.numerador = numerador;
        this.denominador = 1;
    }

    // Metodo Sumar con todas sus variantes
    public static Fraccion sumar(Fraccion a, Fraccion b) {
        Fraccion fraccion = new Fraccion();
        fraccion.setNumerador((a.getNumerador()* b.getDenominador()) + (a.getDenominador() * b.getNumerador()));
        fraccion.setDenominador(a.getDenominador() * b.getDenominador());
        return fraccion;
    }
    public static Fraccion sumar(int a, Fraccion b) {
        Fraccion fraccion = sumar(new Fraccion(a), b);
        return fraccion;
    }
    public static Fraccion sumar(Fraccion a, int b) {
        Fraccion fraccion = sumar(a, new Fraccion(b));
        return fraccion;
    }

    // Metodo Restar con todas sus variantes
    public static Fraccion restar(Fraccion a, Fraccion b) {
        Fraccion fraccion = new Fraccion();
        fraccion.setNumerador((a.getNumerador()* b.getDenominador()) - (a.getDenominador() * b.getNumerador()));
        fraccion.setDenominador(a.getDenominador() * b.getDenominador());
        return fraccion;
    }
    public static Fraccion restar(int a, Fraccion b) {
        Fraccion fraccion = restar(new Fraccion(a), b);
        return fraccion;
    }
    public static Fraccion restar(Fraccion a, int b) {
        Fraccion fraccion = restar(a, new Fraccion(b));
        return fraccion;
    }

    // Metodo Multiplicar con todas sus variantes
    public static Fraccion multiplicar(Fraccion a, Fraccion b) {
        Fraccion fraccion = new Fraccion();
        fraccion.setNumerador(a.getNumerador() * b.getNumerador());
        fraccion.setDenominador(a.getDenominador() * b.getDenominador());
        return fraccion;
    }
    public static Fraccion multiplicar(int a, Fraccion b) {
        Fraccion fraccion = multiplicar(new Fraccion(a), b);
        return fraccion;
    }
    public static Fraccion multiplicacion(Fraccion a, int b) {
        Fraccion fraccion = multiplicar(a, new Fraccion(b));
        return fraccion;
    }

    // Metodo Dividir con todas sus variantes
    public static Fraccion dividir(Fraccion a, Fraccion b) {
        Fraccion fraccion = new Fraccion();
        fraccion.setNumerador(a.getNumerador() * b.getDenominador());
        fraccion.setDenominador(a.getDenominador() * b.getNumerador());
        return fraccion;
    }
    public static Fraccion dividir(int a, Fraccion b) {
        Fraccion fraccion = dividir(new Fraccion(a), b);
        return fraccion;
    }
    public static Fraccion dividir(Fraccion a, int b) {
        Fraccion fraccion = dividir(a, new Fraccion(b));
        return fraccion;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
}
