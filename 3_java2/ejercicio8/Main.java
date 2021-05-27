package ejercicio8;

public class Main {
    public static void main(String[] args) {
        ejercicio8.FiguraGeometrica arr[] = new ejercicio8.FiguraGeometrica[3];
        arr[0] = new ejercicio8.Circulo(2);
        arr[1] = new ejercicio8.Triangulo(2,4);
        arr[2] = new ejercicio8.Rectangulo(4,2);

        double areaPromedio = ejercicio8.FiguraGeometricaUtil.areaPromedio(arr);
        System.out.println(areaPromedio);
    }
}