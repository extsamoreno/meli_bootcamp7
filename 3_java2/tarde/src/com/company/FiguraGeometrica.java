package com.company;

public abstract class FiguraGeometrica {


    public abstract double area();

    public static double areaPromedio (FiguraGeometrica arr[]) {
        double area_promedio = 0;
        for (int i=0; i < arr.length; i++) {
            area_promedio += arr[i].area();
        }
        return area_promedio/arr.length;
    }
}
