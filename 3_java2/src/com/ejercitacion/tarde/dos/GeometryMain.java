package com.ejercitacion.tarde.dos;

public class GeometryMain {


    public static void main(String[] args) {

        FiguraGeometrica triangulo = new Triangulo(4, 5);
        FiguraGeometrica circulo = new Circulo(5);
        FiguraGeometrica rectangulo = new Rectangulo(5, 7);

        FiguraGeometrica[] arr = {triangulo, circulo, rectangulo};

        System.out.println(GeometryUtils.areaPromedio(arr));
    }
}
