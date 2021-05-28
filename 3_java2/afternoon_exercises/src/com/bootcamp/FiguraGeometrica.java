package com.bootcamp;

public abstract class FiguraGeometrica {
    public abstract double area();

    //No tiene sentido sobreescribir el método toString ya que no podemos instanciar
    //esta clase
    @Override
    public String toString() {
        return "FiguraGeometrica{}";
    }
}

