public class Util  {
    public static double areaPromedio(FiguraGeometrica[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].area();
        }
        int avg = sum / arr.length;
        return avg;
    }
    /* FiguraGeométrica no puede instanciarse, por ser abstracta;
        pero sí se puede obtener un arreglo de objetos de una clase
        que herede de ella.
    */

    public static void main(String[] args) {
        FiguraGeometrica arr[] = new FiguraGeometrica[3];
        arr[0] = new Circulo(10);
        arr[1] = new Rectangulo(5, 3);
        arr[2] = new Triangulo(4, 6);

        double areaPromedio = areaPromedio(arr);
        System.out.println("El área promedio de todas las figuras del arreglo es de " + areaPromedio);
    }
}
