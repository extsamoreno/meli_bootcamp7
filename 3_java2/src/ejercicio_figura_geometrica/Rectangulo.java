package ejercicio_figura_geometrica;

public class Rectangulo extends FiguraGeometrica {
     /*
    Respuesta punto 3: Como la clase de la que hereda Rectangulo es abstracta se obliga a que la subclase si tenga todos los métodos abstractos implementado
     */
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        double area;
        area = this.altura*this.base;
        return area;
    }
}
