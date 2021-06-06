package CumpleChiqui;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //FUEGOS
        FuegoArtificial f1 = new IndividualFuegoArtificial();
        FuegoArtificial f2 = new IndividualFuegoArtificial();
        FuegoArtificial f3 = new IndividualFuegoArtificial();
        FuegoArtificial f4 = new IndividualFuegoArtificial();

        ArrayList<FuegoArtificial> fPack1 = new ArrayList<>();
        fPack1.add(f1);
        fPack1.add(f2);
        FuegoArtificial pf1 = new PackFuegoArtificial(fPack1);

        ArrayList<FuegoArtificial> fuegos = new ArrayList<>();
        fuegos.add(f3);
        fuegos.add(f4);
        fuegos.add(pf1);

        //INVITADOS
        ArrayList<Invitado> invitados = new ArrayList<>();

        Invitado invitado_standar1 = new Invitado("Invitado Standar1");
        Invitado invitadoMeli_1 = new InvitadoMeli(235, "Invitado Meli 1");
        Invitado invitadoMeli_2 = new InvitadoMeli(678, "Invitado Meli 2");
        Invitado invitadoMeli_3 = new InvitadoMeli(152, "Invitado Meli 3");

        invitados.add(invitado_standar1);
        invitados.add(invitadoMeli_1);
        invitados.add(invitadoMeli_2);
        invitados.add(invitadoMeli_3);

        Fiesta fiestaChiqui = new Fiesta(invitados, fuegos);

        fiestaChiqui.apagarVela();
        fiestaChiqui.cortarTorta();

    }
}
