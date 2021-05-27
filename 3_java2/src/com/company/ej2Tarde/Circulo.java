package com.company.ej2Tarde;

public class Circulo extends FiguraGeometrica {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.round((Math.PI * Math.pow(this.radio, 2)) * 100) / 100d;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

}
