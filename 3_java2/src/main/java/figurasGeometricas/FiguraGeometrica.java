package figurasGeometricas;

public abstract class FiguraGeometrica {

    public abstract double area();

    @Override
    public String toString() {
        return "FiguraGeometrica{}";
    }
}

/*1. Crear la clase FiguraGeometrica, abstracta y con el método: public abstract double area();
2. Sobreescribir adecuadamente el método toString. Discutir en grupo: ¿tiene sentido sobreescribir el
método toString en una clase abstracta?
*/