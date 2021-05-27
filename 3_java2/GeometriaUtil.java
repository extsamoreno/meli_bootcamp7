public class GeometriaUtil {

    public static double areaPromedio (FiguraGeometrica arr[]){
        double resultado = 0.0;
        int contador = 0;
        for(int i=0 ; i< arr.length ; i++){
            resultado += arr[i].area();
            contador++;
        }

        return resultado/contador;
    }

}
