package ej2;

public class FiguraUtil {
    public static double areaPromedio(FiguraGeometrica arr[]) {
        double sum = 0;
        for (FiguraGeometrica fg : arr) {
            sum += sum + fg.area();
        }
        return sum / arr.length;
    }

    public static void main(String[] args) {
        FiguraGeometrica arr[] = new FiguraGeometrica[2];
        //arr[0]=new Circulo(5);
        //arr[1]=new Circulo(2.5);
        arr[0]=new Rectangulo(5, 2);
        arr[1]=new Triangulo(4,6);

        System.out.println("El area promedio de estas figuras es de: " + areaPromedio(arr));
    }
}
