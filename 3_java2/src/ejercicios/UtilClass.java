package ejercicios;

public class UtilClass {
    public static double areaPromedio(FiguraGeometrica arr[]) {
        double sum = 0;
        for (FiguraGeometrica fg : arr) {
            sum += fg.area();
        }
        return sum / arr.length;
    }

}

