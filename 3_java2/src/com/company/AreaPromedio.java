package com.company;

public class AreaPromedio {
    public static double areaPromedio(FiguraGeometrica array[]){
        double acumulador = 0;

        for (FiguraGeometrica fig: array) {
            acumulador += fig.area();
        }
        return acumulador/array.length;
    }

    public static void main(String[] args) {
        FiguraGeometrica[] array = new FiguraGeometrica[5];
        array[0] = new Circulo(20);
        array[1] = new Triangulo(20, 34);
        array[2] = new Rectangulo(14.3, 12.34);
        array[3] = new Circulo(2);
        array[4] = new Triangulo(20, 10);

        double areaPromedio = areaPromedio(array);
        System.out.println(areaPromedio);
    }
}
