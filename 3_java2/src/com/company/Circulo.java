package com.company;

public class Circulo extends FiguraGeometrica{
    private int radio;

    public Circulo() {
    }

    public Circulo(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(getRadio(),2);
    }
}
