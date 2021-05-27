package com.company;

public class Rectangulo extends FiguraGeometrica {

    private int largo;
    private int ancho;

    public Rectangulo(int lar, int anch) {
        this.largo = lar;
        this.ancho = anch;
    }

    @Override
    public double area() {
        return (double)this.largo*this.ancho;
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "largo=" + largo +
                ", ancho=" + ancho +
                '}';
    }
}
