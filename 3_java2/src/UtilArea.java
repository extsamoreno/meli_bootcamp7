public class UtilArea {
    public static double areaPromedio(FiguraGeometrica arr[]){
        double sum = 0;
        for(FiguraGeometrica x:arr){
            sum+=x.area();
        }
        return sum/arr.length;
    }
}
