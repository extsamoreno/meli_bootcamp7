package mañana;

public class Fraccion {
    private int numerador;
    private int denominador;

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

    //constructores
    public Fraccion() {
    }

    public Fraccion (int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }


    //métodos
    public void sumar(Fraccion fraccion){

    }
    public void restar(Fraccion fraccion){

    }
    public void multiplicar(Fraccion fraccion){
        this.numerador = this.numerador * fraccion.getNumerador();
        this.denominador = this.denominador * fraccion.getDenominador();
    }
    public void dividir(Fraccion fraccion){
        this.numerador = this.numerador * fraccion.getDenominador();
        this.denominador = this.denominador * fraccion.getNumerador();
    }
}
