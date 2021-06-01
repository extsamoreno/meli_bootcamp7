package ejercicios.martegroup;

import java.util.ArrayList;

public class PackFuegoArtificial implements FuegoArtificial {
    private ArrayList<FuegoArtificial> packDeFuegosArtificales;

    public PackFuegoArtificial(ArrayList<FuegoArtificial> packDeFuegosArtificales) {
        this.packDeFuegosArtificales = packDeFuegosArtificales;
    }

    @Override
    public void explotar() {
        for (FuegoArtificial fuegoArtificial : packDeFuegosArtificales) {
            fuegoArtificial.explotar();
        }
    }

}
