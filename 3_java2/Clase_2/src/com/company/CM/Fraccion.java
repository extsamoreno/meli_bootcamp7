package com.company.CM;


/*Crea una clase Fraccion con métodos necesarios para sumar, restar, multiplicar y dividir fracciones.
        Todos los métodos deben estar sobrecargados de modo que también puedan usarse para operar entre fracciones y números enteros (por ejemplo: ⅗+2 o ⅝*4).*/

public class Fraccion {

    private int numerador;
    private int denominador;


    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion() {
    }

    public static Fraccion sumar(Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.denominador=a.denominador*b.denominador;
        resultado.numerador=a.numerador*b.denominador+b.numerador*a.denominador;
        return resultado;
    }

    public static Fraccion sumar(int a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a,1);
        resultado=Fraccion.sumar(na,b);
        return resultado;
    }

    public static Fraccion sumar(Fraccion a, int b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(b,1);
        resultado=Fraccion.sumar(a,na);
        return resultado;
    }
    public static Fraccion sumar(int a, int b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a,1);
        Fraccion na2 = new Fraccion(b,1);
        resultado=Fraccion.sumar(na,na2);
        return resultado;
    }

    public static Fraccion resta(Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.denominador=a.denominador*b.denominador;
        resultado.numerador=a.numerador*b.denominador-b.numerador*a.denominador;
        return resultado;
    }
    public static Fraccion resta(int a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a,1);
        resultado=Fraccion.resta(na,b);
        return resultado;
    }
    public static Fraccion resta(Fraccion a, int b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(b,1);
        resultado=Fraccion.resta(a,na);
        return resultado;
    }
    public static Fraccion resta(int a, int b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a,1);
        Fraccion na2 = new Fraccion(b,1);
        resultado=Fraccion.resta(na,na2);
        return resultado;
    }


    public static Fraccion multiplicacion(Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.denominador=a.denominador*b.denominador;
        resultado.numerador=a.numerador*b.numerador;
        return resultado;
    }
    public static Fraccion multiplicacion(int a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a,1);
        resultado=Fraccion.multiplicacion(na,b);
        return resultado;
    }
    public static Fraccion multiplicacion(Fraccion a, int b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(b,1);
        resultado=Fraccion.multiplicacion(a,na);
        return resultado;
    }
    public static Fraccion multiplicacion(int a, int b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a,1);
        Fraccion na2 = new Fraccion(b,1);
        resultado=Fraccion.multiplicacion(na,na2);
        return resultado;
    }

    public static Fraccion division(Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.numerador=a.numerador*b.denominador;
        resultado.denominador=a.denominador*b.numerador;
        return resultado;
    }
    public static Fraccion division(int a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a,1);
        resultado=Fraccion.division(na,b);
        return resultado;
    }
    public static Fraccion division(Fraccion a, int b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(b,1);
        resultado=Fraccion.division(a,na);
        return resultado;
    }
    public static Fraccion division(int a, int b) {
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a,1);
        Fraccion na2 = new Fraccion(b,1);
        resultado=Fraccion.division(na,na2);
        return resultado;
    }

    @Override
    public String toString() {
        return "Fraccion{" +
                "numerador=" + numerador +
                ", denominador=" + denominador +
                '}';
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
