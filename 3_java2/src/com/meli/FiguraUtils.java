package com.meli;

public class FiguraUtils {

    public static double areaPromedio(FiguraGeometrica[] arr) {

        double areaPromedio = 0;
        for (FiguraGeometrica f : arr) {
            areaPromedio += f.area();
        }
        return Math.round((areaPromedio/arr.length) * 100) / 100d;

    }

}