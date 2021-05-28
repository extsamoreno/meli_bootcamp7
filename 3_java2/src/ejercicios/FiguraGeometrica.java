package ejercicios;

public abstract class FiguraGeometrica
{
    public abstract double area();
    @Override
    public String toString()
    {
        return Double.toString(area());
    }

}
