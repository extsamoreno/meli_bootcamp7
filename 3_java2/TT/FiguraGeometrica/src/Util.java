public class Util  {
    public static double areaPromedio(FiguraGeometrica[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].area();
        }
        int avg = sum / arr.length;
        return avg;
    }
}
