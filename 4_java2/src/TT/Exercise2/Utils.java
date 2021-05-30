package TT.Exercise2;

public class Utils {
    public static double areaPromedio (FiguraGeometrica arr[]){
        double total = 0.0;
        for(FiguraGeometrica figura : arr){
            total += figura.area();
        }
        return total/arr.length;
    }
}
