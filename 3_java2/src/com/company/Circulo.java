package com.company;

public class Circulo extends FiguraGeometrica {

    private double radio;

    //metodos
    @Override
    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }
}
