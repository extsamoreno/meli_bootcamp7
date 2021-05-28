package tarde;

public abstract class FiguraGeometrica {

    public abstract double area();

    @Override
    public String toString(){
        return "El area es: " + area();
    }

}
