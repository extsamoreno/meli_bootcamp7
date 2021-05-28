package meli.ejerc;

public class Main {
    public static void main(String[] args) {

        Fecha fch = new Fecha(5,7,2021);
        System.out.println(fch.toString());
        FiguraGeometrica[] fg = new FiguraGeometrica[3];
        fg[0] = new Circulo(5);
        fg[1] = new Triangulo(5.0, 5.0);
        fg[2] = new Rectangulo(10.0, 10.0);

        System.out.println("El area promedio es: " + StringUtil.areaPromedio(fg));
    }
}
