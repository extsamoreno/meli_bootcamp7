package com.meli;

import java.util.ArrayList;

public class FuegoArtPack implements FuegoArtificial {
    ArrayList<FuegoArtificial> fuegos;

    public FuegoArtPack(ArrayList<FuegoArtificial> fuegos) {
        this.fuegos = fuegos;
    }

    @Override
    public void explotar() {
        for (FuegoArtificial fuego : fuegos) {
            fuego.explotar();
        }
    }
}
