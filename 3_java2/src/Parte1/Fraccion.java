package Parte1;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }


    public Fraccion sumar(Fraccion fraccion1, Fraccion fraccion2){
        Fraccion fraccion  = new Fraccion();
        int numeradorF  =  fraccion1.getDenominador() * fraccion2.getNumerador() +
                            fraccion1.getNumerador()  * fraccion2.getDenominador();

        int denomiradorF = fraccion1.getDenominador() * fraccion2.getDenominador();
        fraccion.setNumerador(numeradorF);
        fraccion.setDenominador(denomiradorF);
        return fraccion;
    }

    public Fraccion sumar(Fraccion fraccion1, int num){
        Fraccion fraccion  = new Fraccion();
        int numeradorF  =  fraccion1.getDenominador() * num +
                fraccion1.getNumerador()  * 1;

        int denomiradorF = fraccion1.getDenominador() * 1;
        fraccion.setNumerador(numeradorF);
        fraccion.setDenominador(denomiradorF);
        return fraccion;
    }


    public Fraccion restar(Fraccion fraccion1, Fraccion fraccion2){
        Fraccion fraccion  = new Fraccion();
        int numeradorF  =  fraccion1.getDenominador() * fraccion2.getNumerador() -
                fraccion1.getNumerador()  * fraccion2.getDenominador();

        int denomiradorF = fraccion1.getDenominador() * fraccion2.getDenominador();
        fraccion.setNumerador(numeradorF);
        fraccion.setDenominador(denomiradorF);
        return fraccion;
    }

    public Fraccion restar(Fraccion fraccion1, int num){
        Fraccion fraccion  = new Fraccion();
        int numeradorF  =  fraccion1.getDenominador() * num -
                fraccion1.getNumerador()  * 1;
        fraccion.setNumerador(numeradorF);
        fraccion.setDenominador(fraccion1.getDenominador() * 1);
        return fraccion;
    }

    public Fraccion multiplicar(Fraccion fraccion1, Fraccion fraccion2){
        Fraccion fraccion  = new Fraccion();
        fraccion.setDenominador(fraccion2.getDenominador() * fraccion1.getDenominador());
        fraccion.setNumerador(fraccion1.getNumerador() * fraccion2.getNumerador());
        return  fraccion;
    }

    public Fraccion multiplicar(Fraccion fraccion1, int num){
        Fraccion fraccion  = new Fraccion();
        fraccion.setDenominador(fraccion1.getDenominador() * 1);
        fraccion.setNumerador(fraccion1.getNumerador() * num);
        return  fraccion;
    }

    public Fraccion dividir(Fraccion fraccion1, Fraccion fraccion2){
        Fraccion fraccion  = new Fraccion();
        fraccion.setNumerador(fraccion1.getNumerador() * fraccion2.getDenominador());
        fraccion.setDenominador(fraccion2.getNumerador() * fraccion1.getDenominador());
        return  fraccion;
    }

    public Fraccion dividir(Fraccion fraccion1, int num){
        Fraccion fraccion  = new Fraccion();
        fraccion.setNumerador(fraccion1.getNumerador() * 1);
        fraccion.setDenominador(num * fraccion1.getDenominador());
        return  fraccion;
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
