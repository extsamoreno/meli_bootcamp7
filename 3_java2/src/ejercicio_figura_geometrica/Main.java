package ejercicio_figura_geometrica;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5);
        circulo.area();
        System.out.println(circulo);

        Triangulo triangulo = new Triangulo(6,8);
        triangulo.area();
        System.out.println(triangulo);

        Rectangulo rectangulo = new Rectangulo(5,6);
        rectangulo.area();
        System.out.println(rectangulo);

        FiguraGeometrica[] arregloFigurasGeometricas = {
                circulo, triangulo, rectangulo
        };
        double promedio = Utilitaria.areaPromedio(arregloFigurasGeometricas);
        System.out.println(promedio);
    }
}
