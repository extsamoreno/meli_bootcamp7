public class UtilFiguraGeometrica {

    public static double areaPromedio(FiguraGeometrica[] figuraGeometricas){

        double sumaAreas = 0.0;

        for (FiguraGeometrica figura: figuraGeometricas) {
            sumaAreas = figura.area() + sumaAreas;
        }

        return sumaAreas/ figuraGeometricas.length;
    }

    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(3);
        Circulo circulo2 = new Circulo(1.5);

        Triangulo triangulo1 = new Triangulo(1.3,4);
        Triangulo triangulo2 = new Triangulo(2,0.5);

        Rectangulo rectangulo1 = new Rectangulo(4,5);
        Rectangulo rectangulo2 = new Rectangulo(3,6);

        FiguraGeometrica[] listaFiguras = new FiguraGeometrica[6];

        listaFiguras[0] = circulo1;
        listaFiguras[1] = circulo2;
        listaFiguras[2] = triangulo1;
        listaFiguras[3] = triangulo2;
        listaFiguras[4] = rectangulo1;
        listaFiguras[5] = rectangulo2;

        System.out.println("El area promedio de la lista es: " + areaPromedio(listaFiguras));

    }
}
