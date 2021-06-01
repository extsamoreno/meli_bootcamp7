package Ejercicio3;

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

        // Lista del evento con packs y fuegos individuales
        ArrayList<FuegoArtificial> listaFuegosEvento = new ArrayList<>();

        FuegoArtificialIndividual fuego1 = new FuegoArtificialIndividual();
        FuegoArtificialIndividual fuego2 = new FuegoArtificialIndividual();
        FuegoArtificialIndividual fuego3 = new FuegoArtificialIndividual();

        // Añadir fuegos individuales al evento
        listaFuegosEvento.add(fuego1);
        listaFuegosEvento.add(fuego2);
        listaFuegosEvento.add(fuego3);

        // Pack
        ArrayList<FuegoArtificial> pack = new ArrayList<>();
        FuegoArtificialIndividual fuego4 = new FuegoArtificialIndividual();
        FuegoArtificialIndividual fuego5 = new FuegoArtificialIndividual();
        FuegoArtificialIndividual fuego6 = new FuegoArtificialIndividual();

        pack.add(fuego4);
        pack.add(fuego5);
        pack.add(fuego6);
        PackFuegosArtificiales pack2 = new PackFuegosArtificiales(pack);
        listaFuegosEvento.add(pack2);

        evento.setListaFuegosArtificiales(listaFuegosEvento);
        evento.apagarVela();
    }
}
