package martegroupsa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        martegroupsa.FuegoArtificial fuegoArtificial1 = new martegroupsa.FuegoArtificialIndividual("PIM");
        martegroupsa.FuegoArtificial fuegoArtificial2 = new martegroupsa.FuegoArtificialIndividual("PAM");
        martegroupsa.FuegoArtificial fuegoArtificial3 = new martegroupsa.FuegoArtificialIndividual("PUM");

        ArrayList<martegroupsa.FuegoArtificial> fuegosArtificiales = new ArrayList<>();
        fuegosArtificiales.add(fuegoArtificial1);
        fuegosArtificiales.add(fuegoArtificial2);
        fuegosArtificiales.add(fuegoArtificial3);
        martegroupsa.FuegoArtificial packFuegosArtificiales = new martegroupsa.FuegoArtificialPack(fuegosArtificiales);

        ArrayList<martegroupsa.FuegoArtificial> fuegoArtificialesEvento= new ArrayList<>();
        fuegoArtificialesEvento.add(fuegoArtificial1);
        fuegoArtificialesEvento.add(fuegoArtificial2);
        fuegoArtificialesEvento.add(fuegoArtificial3);
        fuegoArtificialesEvento.add(packFuegosArtificiales);

        ArrayList<martegroupsa.Invitado> invitadosEvento= new ArrayList<>();
        martegroupsa.Invitado invitadoStandar= new martegroupsa.Invitado("Invitado Standar");
        martegroupsa.Invitado invitadoMeli= new martegroupsa.InvitadoMeli("Invitado Meli");
        invitadosEvento.add(invitadoStandar);
        invitadosEvento.add(invitadoMeli);

        martegroupsa.Evento evento = new martegroupsa.Evento(invitadosEvento,fuegoArtificialesEvento);
        evento.apagarVelas();
    }
}