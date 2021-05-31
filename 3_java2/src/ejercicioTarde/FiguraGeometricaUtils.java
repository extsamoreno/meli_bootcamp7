package ejercicioTarde;

public class FiguraGeometricaUtils {
    public static double areaPromedio (FiguraGeometrica arr[]){
        double area = 0;
        for (int i = 0; i < arr.length; i++) {
            area += arr[i].area();
        }
        return area/arr.length;
    }
}
