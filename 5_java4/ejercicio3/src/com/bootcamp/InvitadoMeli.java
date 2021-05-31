package com.bootcamp;

public class InvitadoMeli extends Invitado {

    public InvitadoMeli(String nombre) {
        super(nombre);
    }

    @Override
    public void comerTorta() {
        System.out.println("Viva la chiqui!!");
    }
}
