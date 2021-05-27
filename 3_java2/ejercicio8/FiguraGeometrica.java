package ejercicio8;

public abstract class FiguraGeometrica {
    public abstract double area();

    /*
    Los métodos abstractos no poseen implementación, por lo tanto, no sabemos como son cada uno; sabemos que son distintos, por lo tanto, deberíamos sobreescribir
    el método por cada figura en ese caso, lo cual no tendría sentido,

    @Override
    public String toString() {
        return super.toString();
    }*/
}