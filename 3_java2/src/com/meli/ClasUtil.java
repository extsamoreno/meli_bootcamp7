package com.meli;

public class ClasUtil {
    public static double areaPromedio(FiguraGeometrica arr[]) {
        double promedio = 0;
        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            promedio += arr[i].area();
            contador++;
        }
        promedio = promedio/contador;
        return promedio;
    }
}
