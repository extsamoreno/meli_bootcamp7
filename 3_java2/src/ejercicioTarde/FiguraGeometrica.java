package ejercicioTarde;

public abstract class FiguraGeometrica {
    public abstract double area();

    @Override
    public String toString() {
        return "FiguraGeometrica con area " + area();
    }
}