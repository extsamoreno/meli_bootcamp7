package com.ejercitacion.m.tercero;

public class InvitadoStandard implements Invitado{

    public String nombre;

    public InvitadoStandard(String nombre) {
        this.nombre = nombre;
    }

    public InvitadoStandard() {
    }

    public void comerTorta() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
