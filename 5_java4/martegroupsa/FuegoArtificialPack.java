package martegroupsa;

import java.util.ArrayList;

public class FuegoArtificialPack implements martegroupsa.FuegoArtificial {
    ArrayList<martegroupsa.FuegoArtificial> fuegosArtificales;

    public FuegoArtificialPack(ArrayList<martegroupsa.FuegoArtificial> fuegosArtificales) {
        this.fuegosArtificales = fuegosArtificales;
    }

    @Override
    public void explotar() {
        for (martegroupsa.FuegoArtificial fuegoArtificial : fuegosArtificales) {
            fuegoArtificial.explotar();
        }
    }
}