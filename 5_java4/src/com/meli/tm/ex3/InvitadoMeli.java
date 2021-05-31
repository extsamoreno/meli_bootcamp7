package com.meli.tm.ex3;

public class InvitadoMeli extends Invitado {
    private Integer nroEmpleado;

    public InvitadoMeli(String nombre, Integer nroEmpleado) {
        super(nombre);
        this.nroEmpleado = nroEmpleado;

    }

    @Override
    public void comer() {
        gritar("Viva la Chiqui");
    }
}
