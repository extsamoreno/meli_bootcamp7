package Parte2.Figure;

public class Main {

    public static void main(String[] args) {
        Figure[] arr = new Figure[3];

        Circulo circulo = new Circulo(2);
        Triangulo triangulo = new Triangulo(12, 15);
        Rectangulo rectangulo = new Rectangulo(10, 2);

        arr[0] = circulo;
        arr[1] = triangulo;
        arr[2] = rectangulo;

        System.out.println(circulo);
        System.out.println(triangulo);
        System.out.println(rectangulo);

        System.out.printf("\nPromedio : %.3f cm²", areaPromedio(arr));
    }

    public static double areaPromedio (Figure arr[]){
        double sum = 0;

        for (Figure f: arr) {
            sum += f.area();
        }

        return sum / arr.length;
    }
}
