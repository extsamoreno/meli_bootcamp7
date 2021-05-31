package com.company.ej1;

public class Pantalon extends Prenda {

    private int talle;

    public Pantalon(String marca, String modelo, int talle) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.talle = talle;
    }

    public int getTalle() {
        return talle;
    }

    public void setTalle(int talle) {
        this.talle = talle;
    }

    @Override
    public String toString() {
        return "Pantalon - Talle= " + this.talle + " - " + super.toString();
    }

}
