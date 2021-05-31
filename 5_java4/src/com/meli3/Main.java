package com.meli3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Invitados invitado1 = new Invitados("Invitado 1", true);
        Invitados invitado2 = new Invitados("Invitado 2", true);
        Invitados invitado3 = new Invitados("Invitado 3", true);
        Invitados invitado4 = new Invitados("Invitado 4", false);
        Invitados invitado5 = new Invitados("Invitado 5", true);
        Invitados invitado6 = new Invitados("Invitado 6", false);

        Pirotecnia fuegoPirotecnico1 = new FuegoArtificial();
        Pirotecnia fuegoPirotecnico2 = new FuegoArtificial();
        Pirotecnia fuegoPirotecnico3 = new FuegoArtificial();
        Pirotecnia fuegoPirotecnico4 = new FuegoArtificial();
        Pirotecnia fuegoPirotecnico5 = new FuegoArtificial();
        Pirotecnia fuegoPirotecnico6 = new FuegoArtificial();
        Pirotecnia fuegoPirotecnico7 = new FuegoArtificial();
        Pirotecnia fuegoPirotecnico8 = new FuegoArtificial();
        Pirotecnia fuegoPirotecnico9 = new FuegoArtificial();

        ArrayList<Invitados> listaInvitados = new ArrayList<>();
        listaInvitados.add(invitado1);
        listaInvitados.add(invitado2);
        listaInvitados.add(invitado3);
        listaInvitados.add(invitado4);
        listaInvitados.add(invitado5);
        listaInvitados.add(invitado6);

        ArrayList<Pirotecnia> fuegosPirotecnicos = new ArrayList<>();
        fuegosPirotecnicos.add(fuegoPirotecnico1);
        fuegosPirotecnicos.add(fuegoPirotecnico2);
        fuegosPirotecnicos.add(fuegoPirotecnico3);
        fuegosPirotecnicos.add(fuegoPirotecnico4);
        fuegosPirotecnicos.add(fuegoPirotecnico5);
        fuegosPirotecnicos.add(fuegoPirotecnico6);
        fuegosPirotecnicos.add(fuegoPirotecnico7);
        fuegosPirotecnicos.add(fuegoPirotecnico8);
        fuegosPirotecnicos.add(fuegoPirotecnico9);

        Evento evento = new Evento(listaInvitados, fuegosPirotecnicos);

        evento.laChiquiApagaVela();

    }
}
