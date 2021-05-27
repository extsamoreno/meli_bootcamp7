package Eje4;

import java.util.zip.DataFormatException;

public class Fraccion {
    private int numerador;
    private int denominador;

    public int getDenominador() {
        return denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    throw new IllegalArgumentException

    public Fraccion sumar(Fraccion f1, Fraccion f2){

    }

    private int maximoDivisor(int a, int b){
        if (a == 0){
            return b;
        }
        return maximoDivisor(b%a, a);

    }
}
