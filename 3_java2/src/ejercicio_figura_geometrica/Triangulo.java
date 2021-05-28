package ejercicio_figura_geometrica;

public class Triangulo extends FiguraGeometrica {
    /*
    Respuesta punto 3: Como la clase de la que hereda Triangulo es abstracta se obliga a que la subclase si tenga todos los métodos abstractos implementado
     */
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area (){
        double area;
        area = this.base*this.altura/2;
        return area;
    }


}
