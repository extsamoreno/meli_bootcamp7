package com.company;

public class Circulo extends FiguraGeometrica{
    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return (double)this.radio*this.radio*Math.PI;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                '}';
    }
}
