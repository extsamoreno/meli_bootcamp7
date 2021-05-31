package com.company.ej3;

public class Invitados {

    private String nombre;
    private String tipo;

    public Invitados(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void gritar(){
        if(tipo.equals("MeLi")){
            System.out.println(nombre + ": Viva la Chiqui!!!");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
