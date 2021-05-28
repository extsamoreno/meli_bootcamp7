package ejercicios;

public class Main {
    public static void main(String[] args) {
        FiguraGeometrica arr[] = new FiguraGeometrica[3];
        arr[0] = new Circulo(10);
        arr[1] = new Rectangulo(5,3);
        arr[2] = new Triangulo(4,6);

        double ap = UtilClass.areaPromedio(arr);
        System.out.println(ap);
    }
}
