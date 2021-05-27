public class Prueba {

    public static void main(String[] args) {
        double resultado = 0.0;
      /*  try {
            Password pass = new PasswordIntermedia();
            pass.setValue("2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        //5
        /*Circulo circulo = new Circulo(2);
        Triangulo triangulo = new Triangulo(2, 2);
        Rectangulo rectangulo = new Rectangulo(2, 2);

        FiguraGeometrica figuraGeometrica[] = new FiguraGeometrica[3];
        figuraGeometrica[0] = circulo;
        figuraGeometrica[1] = triangulo;
        figuraGeometrica[2] = rectangulo;

        resultado = GeometriaUtil.areaPromedio(figuraGeometrica);
        System.out.println(resultado);

*/

        //probando fecha
        Fecha fecha = new Fecha(30,2,2021);
        System.out.println("dia "+fecha.getDia() +" mes "+fecha.getMes()+ " año "+ fecha.getAnio());


    }

}
