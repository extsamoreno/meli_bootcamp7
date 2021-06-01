package ejcio3_evento;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Evento evento = new Evento(crearFuegosArtificiales(), crearInvitados());

        System.out.println("\nMostrando el listado de fuegos artificiales...\n");
        for (FuegoArtificial f : evento.getFuegosArtificiales()) {
            f.mostrarId();
        }

        System.out.println("\nEplotando fuegos artificiales....\n ");
        for (FuegoArtificial f : evento.getFuegosArtificiales()) {
            f.explotar();
        }

        System.out.println("\nRepartiendo la torta... \n");
        for (Invitado i : evento.getInvitados()) {
            i.comer();
        }
    }

    public static List<Invitado> crearInvitados() {

        InvitadoMeli im1 = new InvitadoMeli("im1");
        InvitadoMeli im2 = new InvitadoMeli("im2");
        InvitadoMeli im3 = new InvitadoMeli("im3");

        InvitadoStandard is1 = new InvitadoStandard("is1");
        InvitadoStandard is2 = new InvitadoStandard("is2");
        InvitadoStandard is3 = new InvitadoStandard("is3");

        List<Invitado> listaInvitados = new ArrayList<>();
        listaInvitados.add(im1);
        listaInvitados.add(im2);
        listaInvitados.add(im3);
        listaInvitados.add(is1);
        listaInvitados.add(is2);
        listaInvitados.add(is3);

        return listaInvitados;
    }

    public static List<FuegoArtificial> crearFuegosArtificiales() {

        FuegoArtificialIndividual f1 = new FuegoArtificialIndividual("f1", "pow");
        FuegoArtificialIndividual f2 = new FuegoArtificialIndividual("f2", "paw");
        FuegoArtificialIndividual f3 = new FuegoArtificialIndividual("f3", "pew");
        FuegoArtificialIndividual f4 = new FuegoArtificialIndividual("f4", "piw");
        FuegoArtificialIndividual f5 = new FuegoArtificialIndividual("f5", "puw");

        FuegoArtificialPack pack1 = new FuegoArtificialPack("pack1");
        pack1.getFuegosArtificiales().add(f1);
        pack1.getFuegosArtificiales().add(f2);
        pack1.getFuegosArtificiales().add(f3);

        FuegoArtificialPack pack2 = new FuegoArtificialPack("pack2");
        pack2.getFuegosArtificiales().add(pack1);
        pack2.getFuegosArtificiales().add(f4);
        pack2.getFuegosArtificiales().add(f5);

        List<FuegoArtificial> fuegosArtificiales = new ArrayList<>();

        fuegosArtificiales.add(pack1);
        fuegosArtificiales.add(pack2);

        return fuegosArtificiales;
    }
}
