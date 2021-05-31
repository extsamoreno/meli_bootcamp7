import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainFiesta {

        public static void main(String[] args) {
            FuegosIndividual fi = new FuegosIndividual("iuu");
            FuegosIndividual fi2 = new FuegosIndividual("iiii");
            FuegosPack fa = new FuegosPack(Arrays.asList(fi2,fi,fi2,fi,fi2, new FuegosPack(Arrays.asList(fi,fi2,fi,fi2))));
            Invitado inv1 = new Invitado("Maria", "a", true);
            Invitado inv2 = new Invitado("Pedro", "v", false);
            List<FuegoArtificial> fuegoArtificialList = new ArrayList<FuegoArtificial>(Arrays.asList(fi,fa));
            List<Invitado> invitadoList = new ArrayList<Invitado>(Arrays.asList(inv1,inv2));
            Fiesta fiesta = new Fiesta(invitadoList,fuegoArtificialList);
            fiesta.apagarVela();
            System.out.println("-----------------------");
            fiesta.cortarTortaYComer();

}
}


