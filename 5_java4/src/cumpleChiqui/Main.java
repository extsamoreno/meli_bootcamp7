package cumpleChiqui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        FuegosIndividual fi = new FuegosIndividual("PUUUM");
        FuegosIndividual fi2 = new FuegosIndividual("PAAAAM");
        FuegosPack fa = new FuegosPack(Arrays.asList(fi2,fi,fi2,fi,fi2, new FuegosPack(Arrays.asList(fi,fi2,fi,fi2))));
        Invitado inv = new Invitado("Matias", "Bossa", true);
        Invitado inv2 = new Invitado("Gaston", "Herbes", false);
        List<FuegoArtificial> fuegoArtificialList = new ArrayList<FuegoArtificial>(Arrays.asList(fi,fa));
        List<Invitado> invitadoList = new ArrayList<Invitado>(Arrays.asList(inv,inv,inv,inv2));
        Fiesta fiesta = new Fiesta(invitadoList,fuegoArtificialList);
        fiesta.apagarVela();
        System.out.println("-----------------------");
        fiesta.cortarTortaYComer();

    }
}
