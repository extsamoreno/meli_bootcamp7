public class App {
    public static void main(String[] args) throws Exception {
        
        FiguraGeometrica arr[] = {new Circulo(4.1), new Rectangulo(22.0, 12.0), new Triangulo(12.0, 4.0)};


        System.out.println(FiguraUtil.areaPromedio(arr));
    }
}
