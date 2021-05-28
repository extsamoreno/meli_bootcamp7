package com.company.Clase2JavaTT.Ejercicio2;

import java.util.Arrays;

public class Main {

    public static double areaPromedio(FiguraGeometrica[] arr) {
        double resultado = 0;
        for (int i = 0; i < arr.length; i++) {
            resultado += arr[i].area();
        }

        return resultado / arr.length;
    }

    public static void main(String[] args) {
        FiguraGeometrica[] arr = new FiguraGeometrica[3];
        arr[0] = new Circulo(3);
        arr[1] = new Rectangulo(2, 4);
        arr[2] = new Triangulo(1, 3);


        System.out.println("Las areas de las figuras geometricas son: ");
        Arrays.stream(arr).forEach(p-> System.out.println(p.area()));

        System.out.println("El area promedio de las figuras es: ");
        System.out.println(areaPromedio(arr));
    }
}
