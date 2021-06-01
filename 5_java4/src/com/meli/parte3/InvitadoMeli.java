package com.meli.parte3;

public class InvitadoMeli extends Invitado {

    public InvitadoMeli(String nombre) {
        super(nombre);
    }

    @Override
    public void comerTorta(){
        super.comerTorta();
        System.out.println("Viva la chiqui!!");
    }
}
