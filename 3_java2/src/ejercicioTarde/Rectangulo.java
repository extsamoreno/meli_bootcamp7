package ejercicioTarde;

public class Rectangulo extends  FiguraGeometrica{
    int ladoA;
    int ladoB;

    public Rectangulo(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    @Override
    public double area() {
        return ladoA*ladoB;
    }
}
