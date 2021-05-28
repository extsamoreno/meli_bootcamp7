package com.company;

public class FiguraUtil {
    public static double areaPromedio (FiguraGeometrica arr[]){
        double prom=0;
        for (int i = 0; i < arr.length; i++) {
            prom=prom+arr[i].area();
        }
        prom=prom/arr.length;
        return prom;
    }
}
