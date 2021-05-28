package com.company;

public class Main {

    public static void main(String[] args) {
        FiguraGeometrica[] miCirc=new FiguraGeometrica[3];
        miCirc[0]=new Circulo(2);
        miCirc[1]=new Triangulo(2,2);
        miCirc[2]=new Rectangulo(2,2);
        System.out.println(FiguraUtil.areaPromedio(miCirc));
    }
}
