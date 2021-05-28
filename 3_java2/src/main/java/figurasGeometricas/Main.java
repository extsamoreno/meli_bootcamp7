package figurasGeometricas;

public class Main {

    public static void main(String[] args) {

        Circulo circulo1 = new Circulo(5);
        Circulo circulo2 = new Circulo(10);
        Rectangulo rectangulo1 = new Rectangulo(2, 9);
        Rectangulo rectangulo2 = new Rectangulo(5, 4);
        Triangulo triangulo1 = new Triangulo(12, 3);
        Triangulo triangulo2 = new Triangulo(7, 9);

        FiguraGeometrica[] figuras = new FiguraGeometrica[6];
        figuras[0] = circulo1;
        figuras[1] = circulo2;
        figuras[2] = rectangulo1;
        figuras[3] = rectangulo2;
        figuras[4] = triangulo1;
        figuras[5] = triangulo2;

        System.out.println(GeometricUtils.areaPromedio(figuras));
    }
}
/*Crear un programa, instanciar un FiguraGeometrica[], cargarle datos e invocar a areaPromedio para obtener
el área promedio. Mostrar el resultado.
 */