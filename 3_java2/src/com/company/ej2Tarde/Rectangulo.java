package com.company.ej2Tarde;

public class Rectangulo extends FiguraGeometrica {

    private double largo;
    private double ancho;

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    @Override
    public double area() {
        return this.largo * this.ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

}
