package com.company;

public class Fraction {

    private int denominator;
    private int nominator;

    public Fraction(int denominator, int nominator) {
        this.denominator = denominator;
        this.nominator = nominator;
    }
    public Fraction(){}

    public double getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double getNominator() {
        return nominator;
    }

    public void setNominator(int nominator) {
        this.nominator = nominator;
    }

    public Fraction sum(Fraction fraccion1, Fraction fraccion2){
        Fraction newFraccion  = new Fraction();
        double numeradorF  =  fraccion1.getDenominator() * fraccion2.getNominator() + fraccion1.getNominator()  * fraccion2.getDenominator();
        double denomiradorF = fraccion1.getDenominator() * fraccion2.getDenominator();
        newFraccion.setNominator((int)numeradorF);
        newFraccion.setDenominator((int)denomiradorF);
        return newFraccion;
    }
    public Fraction sum(Fraction fraccion1, int num){
        Fraction fraccion  = new Fraction();
        double numeradorF  =  fraccion1.getDenominator() * num + fraccion1.getNominator()  * 1;
        double denomiradorF = fraccion1.getDenominator() * 1;
        fraccion.setNominator((int)numeradorF);
        fraccion.setDenominator((int)denomiradorF);
        return fraccion;
    }


    public void subtraction(){}
    public void multiply(){}
    public void divide(){}

}
