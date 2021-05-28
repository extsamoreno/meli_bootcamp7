package com.meli;

public class Main {

    public static void main(String[] args) {
        // Programa que prueba el punto 5 del ejercicio 2
        FiguraGeometrica figuras[] = new FiguraGeometrica[3];
        Triangulo triangulo = new Triangulo(10, 5);
        Rectangulo rectangulo = new Rectangulo(10, 5);
        Circulo circulo = new Circulo(5);

        figuras[0] = triangulo;
        figuras[1] = rectangulo;
        figuras[2] = circulo;

        double promedio = ClasUtil.areaPromedio(figuras);

        System.out.println("promedio = " + promedio);
    }
}
