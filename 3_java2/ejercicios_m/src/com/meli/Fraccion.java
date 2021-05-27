package com.meli;


//Crea una clase Fraccion con métodos necesarios para sumar, restar, multiplicar y dividir fracciones.
//Todos los métodos deben estar sobrecargados de modo que también puedan usarse para operar entre fracciones y
//números enteros (por ejemplo: ⅗+2 o ⅝*4).


public class Fraccion {
    private int denominador, numerador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public static int mcm(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado = (a / mcd(num1, num2)) * b;

        return resultado;
    }

    public static int mcd(int num1, int num2) {

        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado = 0;
        do {
            resultado = b;
            b = a % b;
            a = resultado;

        } while (b != 0);

        return resultado;
    }

    public void simplificar() {
        int mcd = Math.abs(mcd(this.getNumerador(),this.getDenominador()));
        this.setNumerador(this.getNumerador()/mcd);
        this.setDenominador(this.getDenominador()/mcd);
    }

    public Fraccion sumar(Fraccion f2) {
        Fraccion resultado = new Fraccion();

        int nuevoDenominador = mcm(this.denominador, f2.getDenominador());
        resultado.setDenominador(nuevoDenominador);

        int nuevoNumerador1 = nuevoDenominador / this.denominador * this.numerador;
        int nuevoNumerador2 = nuevoDenominador / f2.getDenominador() * f2.getNumerador();
        resultado.setNumerador(nuevoNumerador1 + nuevoNumerador2);

        resultado.simplificar();
        return resultado;
    }

    public Fraccion sumar(int entero) {
        Fraccion nuevaFraccion = new Fraccion(entero,1);
        return sumar(nuevaFraccion);
    }

    public Fraccion restar(Fraccion f2) {
        Fraccion fr = new Fraccion(-f2.getNumerador(),f2.getDenominador());
        return sumar(fr);
    }

    public Fraccion restar(int entero) {
        Fraccion nuevaFraccion = new Fraccion(-entero,1);
        return sumar(nuevaFraccion);
    }

    public Fraccion multiplicar(Fraccion f2) {
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(this.getNumerador() * f2.getNumerador());
        resultado.setDenominador(this.getDenominador() * f2.getDenominador());

        resultado.simplificar();
        return resultado;
    }

    public Fraccion multiplicar(int entero) {
        Fraccion nuevaFraccion = new Fraccion(entero,1);
        return multiplicar(nuevaFraccion);
    }

    public Fraccion dividir(Fraccion f2) {
        Fraccion aux = new Fraccion(f2.getDenominador(),f2.getNumerador());
        return multiplicar(aux);
    }

    public Fraccion dividir(int entero) {
        Fraccion nuevaFraccion = new Fraccion(entero,1);
        return dividir(nuevaFraccion);
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }
}
