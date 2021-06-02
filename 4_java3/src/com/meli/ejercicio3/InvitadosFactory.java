package com.meli.ejercicio3;

public class InvitadosFactory {
    public static <T> Invitado crearInvitado(T t){

        return new Invitado(){
            @Override
            public void comerPastel(){
                ((Invitado)t).comerPastel();
            }

        };
    }
}
