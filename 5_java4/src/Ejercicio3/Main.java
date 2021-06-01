package Ejercicio3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Invitados invitados = new InvitadosMeli("Camilo","Botina", 1014275);
        Invitados invitados1 = new InvitadosMeli("Susana","Perez", 519085);
        Invitados invitados2 = new InvitadosMeli("Stefania","Perez", 12338928);
        Invitados invitados3 = new InvitadosStandard("Pepito","Ramirez",123456);
        Invitados invitados4 = new InvitadosStandard("Andres","Vasquez",654321);

        ArrayList<Invitados> listaInvitados = new ArrayList<>();
        listaInvitados.add(invitados);
        listaInvitados.add(invitados1);
        listaInvitados.add(invitados2);
        listaInvitados.add(invitados3);
        listaInvitados.add(invitados4);

        FuegosArtificiales fuegosArtificiales = new FuegosArtificialesIndividuales();
        fuegosArtificiales.setRuido("Boom");
        FuegosArtificiales fuegosArtificiales1 = new FuegosArtificialesIndividuales();
        fuegosArtificiales1.setRuido("Bam");
        PackFuegosArtificiales fuegosArtificiales2 = new PackFuegosArtificiales();
        fuegosArtificiales2.agregarFuegosArtificiales(fuegosArtificiales);
        fuegosArtificiales2.agregarFuegosArtificiales(fuegosArtificiales1);

        ArrayList<FuegosArtificiales> listaFuegosArtificiales = new ArrayList<>();
        listaFuegosArtificiales.add(fuegosArtificiales);
        listaFuegosArtificiales.add(fuegosArtificiales1);
        listaFuegosArtificiales.add(fuegosArtificiales2);

        Fiesta fiesta = new Fiesta(listaInvitados,listaFuegosArtificiales);
        fiesta.apagarVelas();
    }
}
