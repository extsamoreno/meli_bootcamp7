package ejercicio_figura_geometrica;

public abstract class FiguraGeometrica {
    public abstract double area ();
    /*
    Respuesta punto 2: Si aquello que se va a imprimir sin importar la clase es lo mismo sì tiene sentido poner el tostring en la clase
    abstract y no en cada una de las clases especificas
     */

    @Override
    public String toString() {
        return "El área es: "+area();
    }
}
