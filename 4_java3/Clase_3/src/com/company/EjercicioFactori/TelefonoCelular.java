package com.company.EjercicioFactori;

public class TelefonoCelular implements Comunicador {
    @Override
    public void enviarMensaje(String mns) {
        System.out.println("Soy la paloma y digo: " + mns);

    }
}
