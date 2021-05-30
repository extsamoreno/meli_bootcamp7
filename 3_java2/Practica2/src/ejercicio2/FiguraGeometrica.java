package ejercicio2;

public abstract class FiguraGeometrica {

    public abstract double area();

    @Override
    public String toString() {
        return super.toString();
    }

    public void imprimirArea()
    {
        System.out.println("Area de la figura:"+area());
    }
}
