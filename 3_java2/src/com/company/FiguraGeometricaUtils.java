package com.company;

public class FiguraGeometricaUtils {

    public static double areaPromedio(FiguraGeometrica[] arr) {
        int cantidadElementos = arr.length;
        double suma = 0;

        for (int i = 0; i <= cantidadElementos; i++) {
            suma = arr[i].area();
        }

        return (suma / cantidadElementos);
    }
}
