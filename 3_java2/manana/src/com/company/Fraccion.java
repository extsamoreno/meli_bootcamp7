package com.company;

public class Fraccion {
    private int numerador;
    private int denomiador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denomiador) {
        this.numerador = numerador;
        this.denomiador = denomiador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenomiador() {
        return denomiador;
    }

    public void setDenomiador(int denomiador) {
        this.denomiador = denomiador;
    }

    public void sumar(Fraccion fraccion) {
        int numerador_aux = fraccion.numerador*this.denomiador + this.numerador*fraccion.denomiador;
        int denomiador_aux = fraccion.denomiador*this.denomiador;

        int divisor = gcd(numerador_aux, denomiador_aux);

        this.numerador = numerador_aux/divisor;
        this.denomiador = denomiador_aux/divisor;
    }

    public void sumar(int numero) {
        Fraccion aux = new Fraccion(numero, 1);
        this.sumar(aux);
    }

    public void restar(Fraccion fraccion) {
        int numerador_aux = (fraccion.numerador*this.denomiador)*(-1) + this.numerador*fraccion.denomiador;
        int denomiador_aux = fraccion.denomiador*this.denomiador;

        int divisor = gcd(numerador_aux, denomiador_aux);

        this.numerador = numerador_aux/divisor;
        this.denomiador = denomiador_aux/divisor;
    }

    public void restar(int numero) {
        Fraccion aux = new Fraccion(numero, 1);
        this.restar(aux);
    }

    public void multiplicar(Fraccion fraccion) {
        int numerador_aux = fraccion.numerador * this.numerador;
        int denomiador_aux = fraccion.denomiador * this.denomiador;

        int divisor = gcd(numerador_aux, denomiador_aux);

        this.numerador = numerador_aux/divisor;
        this.denomiador = denomiador_aux/divisor;
    }

    public void multiplicar(int numero) {
        Fraccion aux = new Fraccion(numero, 1);
        this.multiplicar(aux);
    }

    public void dividir(Fraccion fraccion) {
        int numerador_aux = fraccion.denomiador * this.numerador;
        int denomiador_aux = fraccion.numerador * this.denomiador;

        int divisor = gcd(numerador_aux, denomiador_aux);

        this.numerador = numerador_aux/divisor;
        this.denomiador = denomiador_aux/divisor;
    }

    public void dividir(int numero) {
        Fraccion aux = new Fraccion(numero, 1);
        this.dividir(aux);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        return "Fraccion{" +
                "numerador=" + numerador +
                ", denomiador=" + denomiador +
                '}';
    }
}
