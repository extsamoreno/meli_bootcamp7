public class FiguraUtil {
    public static double areaPromedio(FiguraGeometrica[] arr){
        double sum=0;
        for (int i=0; i<arr.length; i++){
            sum+=arr[i].area();
        }
        return sum/arr.length;
    }
}
