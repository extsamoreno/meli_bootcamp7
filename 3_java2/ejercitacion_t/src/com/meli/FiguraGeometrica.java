package com.meli;

public abstract class FiguraGeometrica {
    public abstract double area();

//    No tiene sentido hacer un override de toString porque cada figura tiene su forma distinta de
//    imprimirse y habría que volver a hacer un override del metodo por cada figura
//    @Override
//    public String toString() {
//        return "FiguraGeometrica{}";
//    }
}
