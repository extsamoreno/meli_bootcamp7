package TT.Exercise2;

public class Main {
    public static void main(String[] args) {
        double prom = Utils.areaPromedio(new FiguraGeometrica[]{ new Circulo(2),new Rectangulo(1,2),new Triangulo(2,2)});
        System.out.println(prom);
    }
}
