package com.company;

public class Ejercicio_2 {
    public static void main(String[] args) {

        FiguraGeometrica arr [] = new FiguraGeometrica[3];
        arr[0] = new Circulo(10);
        arr[1] = new Rectangulo(5,3);
        arr[2] = new Triangulo(4,6);
        double ap =areaPromedio(arr);
        System.out.println(ap);
    }

    public static double areaPromedio(FiguraGeometrica arr[]){
        double sum=0;
        for(FiguraGeometrica fg :arr){
            sum+=fg.area();
        }
        return sum/ arr.length;
    }
}
