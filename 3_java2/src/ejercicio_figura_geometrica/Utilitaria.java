package ejercicio_figura_geometrica;

public class Utilitaria {
    public static double areaPromedio(FiguraGeometrica arr[]){
        double areaPromedio = 0;
        for(int i = 0; i<arr.length;i++) {
            areaPromedio += arr[i].area();
        }
        areaPromedio = areaPromedio/arr.length;
        return areaPromedio;
    }



}
