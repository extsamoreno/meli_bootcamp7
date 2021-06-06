package CumpleChiqui;

import java.util.ArrayList;

public class PackFuegoArtificial implements FuegoArtificial {

    ArrayList<FuegoArtificial> fuegos;

    public PackFuegoArtificial(ArrayList<FuegoArtificial> fuegos) {
        this.fuegos = fuegos;
    }

    @Override
    public void explotar() {
        for (FuegoArtificial fuego : fuegos) {
            fuego.explotar();
        }
    }
}
