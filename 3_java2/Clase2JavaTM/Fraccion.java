package com.company.Clase2JavaTM;

public class Fraccion {

    private int numerador,denominador;

    public Fraccion() {
    }

    public Fraccion sumar(Fraccion a , Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*b.getDenominador()+(b.getNumerador()*a.getDenominador()));
        resultado.setDenominador(a.getDenominador()*b.getDenominador());
        return resultado;
    }

    public Fraccion sumar(Fraccion a , int numerador , int denominador){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*denominador+(numerador*a.getDenominador()));
        resultado.setDenominador(a.getDenominador()*denominador);
        return resultado;
    }

    public Fraccion sumar(Fraccion a , int numero){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*1+(numero*a.getDenominador()));
        resultado.setDenominador(a.getDenominador()*1);
        return resultado;
    }

    public Fraccion multiplicar(Fraccion a , Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*b.getNumerador());
        resultado.setDenominador(a.getDenominador()*b.getDenominador());
        return resultado;
    }

    public Fraccion dividir(Fraccion a , Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*b.getDenominador());
        resultado.setDenominador(a.getDenominador()*b.getNumerador());
        return resultado;
    }

    public Fraccion restar(Fraccion a , Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*b.getDenominador()-(b.getNumerador()*a.getDenominador()));
        resultado.setDenominador(a.getDenominador()*b.getDenominador());
        return resultado;
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


    public static void main(String[] args) {
        Fraccion fr1 = new Fraccion();
        Fraccion fr2 = new Fraccion();
        Fraccion fr = new Fraccion();

        fr1.setNumerador(1);
        fr1.setDenominador(2);
        fr2.setNumerador(1);
        fr2.setDenominador(2);

        fr = fr.sumar(fr1,fr2);
        System.out.println("Los datos son: numeroA= "+fr1.getNumerador()+"/"+fr1.getDenominador()+ " numeroB "+fr2.getNumerador()+"/"+fr2.getDenominador());
        System.out.println("Suma: "+fr.getNumerador()+"/"+ fr.getDenominador());

        fr = fr.restar(fr1,fr2);
        System.out.println("Resta: "+fr.getNumerador()+"/"+ fr.getDenominador());

        fr = fr.multiplicar(fr1,fr2);
        System.out.println("Multiplicacion: "+fr.getNumerador()+"/"+ fr.getDenominador());

        fr = fr.dividir(fr1,fr2);
        System.out.println("Dividir: "+fr.getNumerador()+"/"+ fr.getDenominador());

    }

}