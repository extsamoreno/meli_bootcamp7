package practicaTT.figura;

public class Utils {

    public static double areaPromedio(FiguraGeometrica arr[]) {
        double promedio = 0;

        for (int i = 0; i < arr.length; i++) {
            promedio += arr[i].area();
        }

        return promedio / arr.length;
    }

}
