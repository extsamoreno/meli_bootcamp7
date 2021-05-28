package practicaTT.figura;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        FiguraGeometrica rectangulo = new Rectangulo(3, 4);
        FiguraGeometrica triangulo = new Triangulo(3, 4);
        FiguraGeometrica circulo = new Circulo( 1.5);
        FiguraGeometrica circulo2 = new Circulo( 5);
        FiguraGeometrica array[]={rectangulo,triangulo,circulo,circulo2};



        System.out.println(rectangulo);
        System.out.println(triangulo);
        System.out.println(circulo);
        System.out.println(circulo2);
        System.out.println(Utils.areaPromedio(array));
    }
}
