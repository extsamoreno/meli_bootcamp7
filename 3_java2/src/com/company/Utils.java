package com.company;

public class Utils {

    public static double areaPromedio (GeometricFigure arr[]){

        double areaPromedio =0;

        for(int i=0;i <arr.length;i++){
            areaPromedio += arr[i].area();
        }
        return areaPromedio;
    }
}
