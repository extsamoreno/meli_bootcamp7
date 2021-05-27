package com.company;

public class Triangulo extends FiguraGeometrica{
    private int base;
    private int altura;

    public Triangulo(int b, int a) {
        this.base = b;
        this.altura = a;
    }

    @Override
    public double area() {
        return (double)base*altura/2 ;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + base +
                ", altura=" + altura +
                '}';
    }
}
