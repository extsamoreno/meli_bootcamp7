package marteGroupSA;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MarteGroupSA marteGroupSA = new MarteGroupSA();

        FuegoArtificial individual1 = new FuegoArtificialIndividual();
        FuegoArtificial individual2 = new FuegoArtificialIndividual();
        FuegoArtificial individual3 = new FuegoArtificialIndividual();

        ArrayList<FuegoArtificial> fuegosPack = new ArrayList<>();
        fuegosPack.add(individual1);
        fuegosPack.add(individual2);
        fuegosPack.add(individual3);

        FuegoArtificial pack1 = new PackFuegoArtificial(fuegosPack);

        ArrayList<FuegoArtificial> fuegosArtificiales = new ArrayList<>();
        fuegosArtificiales.add(individual1);
        fuegosArtificiales.add(individual2);
        fuegosArtificiales.add(individual3);
        fuegosArtificiales.add(pack1);

        Invitado invitadoMELI1 = new InvitadoMELI();
        Invitado invitadoMELI2 = new InvitadoMELI();
        Invitado invitadoMELI3 = new InvitadoMELI();

        Invitado invitadoStandar1 = new InvitadoStandar();
        Invitado invitadoStandar2 = new InvitadoStandar();
        Invitado invitadoStandar3 = new InvitadoStandar();

        ArrayList<Invitado> invitados = new ArrayList<>();
        invitados.add(invitadoMELI1);
        invitados.add(invitadoStandar1);
        invitados.add(invitadoMELI2);
        invitados.add(invitadoStandar2);
        invitados.add(invitadoMELI3);
        invitados.add(invitadoStandar3);

        marteGroupSA.setInvitados(invitados);
        marteGroupSA.setFuegosArtificiales(fuegosArtificiales);

        marteGroupSA.reventarFuegosArtificiales();
        marteGroupSA.repartirTorta();
    }
}
