package ejercicio_figura_geometrica;

public class Circulo extends FiguraGeometrica {

    /*
    Respuesta punto 3: Como la clase de la que hereda Círculo es abstracta se obliga a que la subclase si tenga todos los métodos abstractos implementado
     */
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double area (){
        double area = Math.PI*Math.pow(this.radio,2);
        return area;

    }

}
