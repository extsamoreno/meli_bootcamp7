package ejercicios.martegroup;

import java.util.ArrayList;

public class main3 {

    public static void main(String[] args) {
        ArrayList<Invitado> listaDeInvitados =  new ArrayList<>();
        InvitadoMeli invitado1 = new InvitadoMeli("Carlos", "Perez",33234123);
        listaDeInvitados.add(invitado1);

        FuegoArtificialIndividual fuego1 = new FuegoArtificialIndividual("PAM");
        FuegoArtificialIndividual fuego2 = new FuegoArtificialIndividual("BING");
        FuegoArtificialIndividual fuego3 = new FuegoArtificialIndividual("BOOM");
        ArrayList<FuegoArtificial> listaFuegos = new ArrayList<>();
        listaFuegos.add(fuego3);
        listaFuegos.add(fuego2);
        listaFuegos.add(fuego1);
        PackFuegoArtificial pack1 = new PackFuegoArtificial(listaFuegos);
        ArrayList<FuegoArtificial> listaDeFuegosArtificiales = new ArrayList<>();
        listaDeFuegosArtificiales.add(fuego1);
        listaDeFuegosArtificiales.add(fuego2);
        listaDeFuegosArtificiales.add(fuego3);
        listaDeFuegosArtificiales.add(pack1);

        Evento centenarioLachiqui = new Evento(listaDeInvitados, listaDeFuegosArtificiales );

        InvitadoMeli invitadoMeli1 = new InvitadoMeli("Pablo","Jaimito",1234567);
        centenarioLachiqui.cargarInvitadoMeli(invitadoMeli1);
        InvitadoStandard invitadoStandard1 = new InvitadoStandard("Maria", "Lavolpe", 56789054);
        centenarioLachiqui.cargarInvitadoStandard(invitadoStandard1);
        InvitadoStandard invitadoStandard2 = new InvitadoStandard("Rosario", "Diaz", 34555678);
        centenarioLachiqui.cargarInvitadoStandard(invitadoStandard2);
        InvitadoStandard invitadoStandard3 = new InvitadoStandard("Juanita", "Viale", 23789054);
        centenarioLachiqui.cargarInvitadoStandard(invitadoStandard3);

        centenarioLachiqui.soplarVelas();

    }

}
