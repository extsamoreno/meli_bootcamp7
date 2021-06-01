package cumpleChiqui;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Invitado invitado1 = InvitadosFabrica.crearInvitado(1);
        Invitado invitado2 = InvitadosFabrica.crearInvitado(2);
        ArrayList<Invitado> invitados = new ArrayList<Invitado>();

        invitados.add(invitado1);
        invitados.add(invitado2);
        //invitado1.gritoPosComida();

        fuegoArtificialIndividual fuego1 = new fuegoArtificialIndividual();
        fuego1.setSonidoAlExplotar("PIM");
        //fuego1.getSonidoAlExplotar();

        fuegoArtificialIndividual fuego2 = new fuegoArtificialIndividual();
        fuego2.setSonidoAlExplotar("PUM");
        //fuego2.getSonidoAlExplotar();

        fuegoArtificialIndividual fuego3 = new fuegoArtificialIndividual();
        fuego3.setSonidoAlExplotar("PAM");
        //fuego3.getSonidoAlExplotar();


        fuegoArtificialPack fuegos = new fuegoArtificialPack();
        fuegos.add(fuego1);
        fuegos.add(fuego2);
        fuegos.add(fuego3);

        //fuegos.getSonidoAlExplotar();

        fuegoArtificialPack fuegos1 = new fuegoArtificialPack();
        fuegos1.add(fuegos);
        fuegos.add(fuego3);
        fuegos.add(fuego2);
        fuegos.add(fuego1);
        //fuegos1.getSonidoAlExplotar();

        Evento eventoChiqui = new Evento("Cumple Chiqui", fuegos1, invitados);
        eventoChiqui.ejecutarEvento();
    }
}
