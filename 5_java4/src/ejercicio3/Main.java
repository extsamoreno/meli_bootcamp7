package ejercicio3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Evento evento = new Evento();

        Invitados inv1 = new Invitados("Carlos", TipoInvitado.Meli.ordinal());
        Invitados inv2 = new Invitados("Juan", TipoInvitado.Standard.ordinal());
        Invitados inv3 = new Invitados("Mario", TipoInvitado.Meli.ordinal());

        evento.addInvitado(inv1);
        evento.addInvitado(inv2);
        evento.addInvitado(inv3);

        FuegoArtificialIndividual fuego1 = new FuegoArtificialIndividual();


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