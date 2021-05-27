package EjerciciosTarde2;

public class MainFG {

    public static void main(String[] args) {

        FiguraGeometrica arr[] = new FiguraGeometrica[3];
        arr[0] = new Circulo(5);
        arr[1] = new Triangulo(8,2);
        arr[2] = new Rectangulo(3,7);

        double areaPromedio = ClaseUtilitaria.areaPromedio(arr);
        System.out.println(areaPromedio);
    }
}

// Clase utilitaria
class ClaseUtilitaria{

    public static double areaPromedio(FiguraGeometrica arr[]){

        double sum = 0;

        for(FiguraGeometrica fg : arr){
            sum += fg.area();
        }

        return sum/arr.length;
    }
}
