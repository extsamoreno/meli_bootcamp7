package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            Password pass = new PasswordSimple();
            pass.setValue("aaaa");
        } catch (Exception e) {
            System.out.println("hola");
        }

        FiguraGeometrica circ = new Circulo(4);
        FiguraGeometrica rect = new Rectangulo(4,5);
        FiguraGeometrica tri = new Triangulo(4,7);

        FiguraGeometrica[] arr = new FiguraGeometrica[3];
        arr[0] = circ;
        arr[1] = rect;
        arr[2] = tri;

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(circ.area());
        System.out.println(rect.area());
        System.out.println(tri.area());
        System.out.println(FiguraGeometrica.areaPromedio(arr));

    }
}
