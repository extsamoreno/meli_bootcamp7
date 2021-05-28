public class FiguraGeometricaUtils {

    public static void main(String[] args) {

        FiguraGeometrica[] figuras={
                new Circulo(7),
                new Rectangulo(5,7),
                new Triangulo(3.5,2)
        };

        System.out.println(areaPromedio(figuras));
    }

    public static double areaPromedio(FiguraGeometrica arr[]){
        double suma=0;
        for (int i = 0; i < arr.length; i++) {
            suma+=arr[i].area();
        }
        return suma/arr.length;
    }


}
