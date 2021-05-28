package clasesTardeEjercicio2;

public abstract class FiguraGeometrica {

    public abstract double area();

    public void imprimirArea(){
        System.out.println("Area de la figura: "+area());
    }

    @Override
    public String toString() {
        return "FiguraGeometrica{}";
    }
}
