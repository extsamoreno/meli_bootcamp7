package com.meli;

public class Circulo extends FiguraGeometrica{
    private double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.pow(Math.PI * this.radio, 2);
    }
}
