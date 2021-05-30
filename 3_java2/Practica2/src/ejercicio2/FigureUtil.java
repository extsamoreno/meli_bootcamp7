package ejercicio2;

public class FigureUtil {

    public static double areaPromedio(FiguraGeometrica arr[]){
        double areaP = 0;
        for(FiguraGeometrica fg:arr){
            areaP += fg.area();
        };
        return areaP/ arr.length;
    }
}
