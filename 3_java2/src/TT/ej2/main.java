package TT.ej2;

public class main {
    public static void main(String[] args) {
        FiguraGeometrica arr[] = new FiguraGeometrica[3];
        arr[0] = new Circulo(10);
        arr[1] = new Rectangulo(5, 3);
        arr[2] = new Triangulo(4, 6);
        double ap = AreaPromedio.areaPromedio(arr); //no es necesario hacer new ya que es un static
        System.out.println(ap);
    }
}
