package com.company.ej1;

public class Remera extends Prenda {

    private String talle;

    public Remera(String marca, String modelo, String talle) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.talle = talle;
    }

    @Override
    public String toString() {
        return "Remera - Talle= " + this.talle + " - " + super.toString();
    }

}
