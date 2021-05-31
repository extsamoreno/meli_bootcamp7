package com.company.ej1;

public class Campera extends Prenda {

    private String talle;

    public Campera(String marca, String modelo, String talle) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.talle = talle;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    @Override
    public String toString() {
        return "Campera - Talle= " + this.talle + " - " + super.toString();
    }

}
