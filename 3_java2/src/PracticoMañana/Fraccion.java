package PracticoMañana;

import java.util.DuplicateFormatFlagsException;

public class Fraccion {


    private int numerador;
    private int denominador;

    public Fraccion(){
        this.denominador = 0;
        this.numerador = 0;
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(Fraccion f){
        this.numerador = f.getNumerador();
        this.denominador = f.getDenominador();
    }

    public Fraccion sumar(Fraccion f1, Fraccion f2){
        Fraccion result;

        if(f1.denominador != f2.denominador){
            this.numerador = f1.getNumerador() * f2.getDenominador() + f2.getNumerador() * f1.getDenominador();
            this.denominador = f1.getDenominador() * f2.getDenominador();
        }else{
            this.numerador = f1.getNumerador() + f2.getNumerador();
            this.denominador = f1.getDenominador();
        }

        result = new Fraccion(this.numerador, this.denominador);

        return result;
    }

    public Fraccion sumar(Fraccion f1, int n2){
        Fraccion result;

        this.numerador = f1.getNumerador() + ( n2 * f1.getDenominador() );
        this. denominador = f1.getDenominador();

        result = new Fraccion(this.numerador, this.denominador);

        return result;
    }

    public Fraccion restar(Fraccion f1, Fraccion f2){
        Fraccion result;


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
