package com.bootcamp;

import java.util.ArrayList;

public class FuegoPack implements FuegoArtificial {

    ArrayList<FuegoArtificial> fuegos;

    public FuegoPack(ArrayList<FuegoArtificial> fuegos) {
        this.fuegos = fuegos;
    }

    @Override
    public void explotar() {
        for (FuegoArtificial fuego : fuegos) {
            fuego.explotar();
        }
    }

}
