package com.company;

public class Fraccion {

    public float numerador;
    public float denominador;

    public Fraccion(float numerador, float denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void setNumerador(float numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public  static Fraccion sumar(Fraccion a, Fraccion b){
        return (a.getNumerador()/a.denominador) + (b.getNumerador()/b.denominador);
    }

    public  static double restar(double a, double b){
        return a - b;
    }

    public  static double multiplicar(double a, double b){
        return a * b;
    }

    public  static double dividir(double a, double b){
        if (b>0){
            return a / b;
        }
        return 0;
    }

    public  static double sumar(int a, double b){
        return (double)a + b;
    }

    public  static double restar(int a, double b){
        return a - b;
    }

    public  static double multiplicar(int a, double b){
        return (double)a * b;
    }

    public  static double dividir(int a, double b){
        if (b>0){
            return (double) a / b;
        }
        return 0;

    }

}
