package Exercise2;

public class Utils {

    public static double areaPromedio(FiguraGeometrica[] arr) {
        double resultado = 0;
        for (int i = 0; i < arr.length; i++) {
            resultado += arr[i].area();
        }

        return resultado / arr.length;
    }
}
