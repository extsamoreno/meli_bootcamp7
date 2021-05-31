package com.ejercitacion.m.tercero;

public class InvitadoMeli implements Invitado {


    private String nombre;

    public InvitadoMeli(String nombre) {

    }

    public InvitadoMeli() {
    }

    @Override
    public void comerTorta() {
       System.out.println("Viva la Chiqui!!");
    }
}
