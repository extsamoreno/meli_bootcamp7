package com.company;

public class Rectangulo extends FiguraGeometrica{
    private int alto;
    private int ancho;

    public Rectangulo() {
    }

    public Rectangulo(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    @Override
    public double area() {
        return (alto*ancho);
    }
}
