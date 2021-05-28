public class FiguraUtil {

    public static double areaPromedio (FiguraGeometrica arr[]){

        double output = 0.0;

        for (FiguraGeometrica figura : arr) {
            
            output += figura.area();
        }

        return output/arr.length;
    }
}
