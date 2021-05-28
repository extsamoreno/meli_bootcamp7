package meli.ejerc.Ej2Tarde;

public class GeometricsUtility {
    public static void main(String[] args) {
        FiguraGeometrica[] arrFig = new FiguraGeometrica[]{
                new Circulo(2),
                new Triangulo(2,3),
                new Rectangulo(2,3)
        };
        System.out.println(areaPromedio(arrFig));
    }

    public static double areaPromedio (FiguraGeometrica[] arr){
        double promedioaArea = 0;
        for (FiguraGeometrica i :arr){
            promedioaArea += i.area();
        }
        return  promedioaArea / arr.length;
    }
}
