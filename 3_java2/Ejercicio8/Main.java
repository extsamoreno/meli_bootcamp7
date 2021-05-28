package Ejercicio8;

public class Main {
    public static void main(String[] args) {
        FiguraGeometrica arr[] =new FiguraGeometrica[3];
        arr[0]=new Circulo(1);
        arr[1]=new Rectangulo(10,5);
        arr[2]= new Triangulo(3,5);

        double ap= FiguraGeometrica.areaPromedio(arr);
        System.out.println(ap);
    }
}
