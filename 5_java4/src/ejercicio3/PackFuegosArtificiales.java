package ejercicio3;

import java.util.ArrayList;

public class PackFuegosArtificiales implements FuegoArtificial{

    ArrayList<FuegoArtificial> listaFuegosArtificiales;

    public PackFuegosArtificiales(ArrayList<FuegoArtificial> listaFuegosArtificiales) {
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }

    @Override
    public void accionar() {

        System.out.println("Accionando packs de fuegos");
        for (FuegoArtificial f : listaFuegosArtificiales) {
            if(f instanceof FuegoArtificialIndividual){
                System.out.println(((FuegoArtificialIndividual) f).getTipoRuido());
            }
        }
    }
}
