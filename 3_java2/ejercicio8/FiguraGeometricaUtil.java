package ejercicio8;

public class FiguraGeometricaUtil {
    public static double areaPromedio (ejercicio8.FiguraGeometrica arr[]) {
        double sumaAreas = 0.0;
        double areaPromedio = 0.0;

        for(ejercicio8.FiguraGeometrica figuraGeometrica : arr) {
            sumaAreas += figuraGeometrica.area();
        }

        areaPromedio = sumaAreas / arr.length;

        return areaPromedio;
    }
}