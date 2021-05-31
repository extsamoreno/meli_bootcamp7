package com.company.ej3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Evento evento = new Evento();

        Invitados inv1 = new Invitados("Carlos", "MeLi");
        Invitados inv2 = new Invitados("Juan", "Standard");
        Invitados inv3 = new Invitados("Mario", "MeLi");

        evento.addInvitado(inv1);
        evento.addInvitado(inv2);
        evento.addInvitado(inv3);

        FuegoArtificialIndividual fuego1 = new FuegoArtificialIndividual();
        FuegoArtificialIndividual fuego2 = new FuegoArtificialIndividual();
        FuegoArtificialIndividual fuego3 = new FuegoArtificialIndividual();

        /*ArrayList<FuegoArtificial> listaFuegos = new ArrayList<>();
        listaFuegos.add(fuego1);
        listaFuegos.add(fuego2);
        listaFuegos.add(fuego3);*/

        // Pack
        FuegoArtificialIndividual fuego4 = new FuegoArtificialIndividual();
        FuegoArtificialIndividual fuego5 = new FuegoArtificialIndividual();
        FuegoArtificialIndividual fuego6 = new FuegoArtificialIndividual();
        ArrayList<FuegoArtificial> listaFuegos2 = new ArrayList<>();

        listaFuegos2.add(fuego4);
        listaFuegos2.add(fuego5);
        listaFuegos2.add(fuego6);

        PackFuegosArtificiales pack1 = new PackFuegosArtificiales(listaFuegos2);
        listaFuegos2.add(fuego1);
        listaFuegos2.add(pack1);

        evento.setListaFuegosArtificiales(listaFuegos2);
        evento.apagarVela();
    }
}
