package tarde;

public class UtilFiguras {
    public static void main(String[] args) {
        FiguraGeometrica arr[] = new FiguraGeometrica[3];
        arr[0] = new Rectangulo(4,2);
        arr[1] = new Circulo(10);
        arr[2] = new Triangulo(4, 8);

        double promedio = areaPromedio(arr);

        System.out.println("Promedio:" + promedio);
    }



    public static double areaPromedio (FiguraGeometrica arr[]){

        double tot = 0;

        for (FiguraGeometrica fig : arr) {
            tot +=fig.area();
        }

        return tot/arr.length;
    }
}
