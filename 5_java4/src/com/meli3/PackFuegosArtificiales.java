package com.meli3;

import java.util.ArrayList;

public class PackFuegosArtificiales implements Pirotecnia {
    private ArrayList<Pirotecnia> fuegosArtificiales;

    public PackFuegosArtificiales(ArrayList<Pirotecnia> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }

    @Override
    public void accionar() {
        for (Pirotecnia fuegoArtificial : fuegosArtificiales) {
            fuegoArtificial.accionar();
        }
    }

    public ArrayList<Pirotecnia> getFuegosArtificiales() {
        return fuegosArtificiales;
    }

    public void setFuegosArtificiales(ArrayList<Pirotecnia> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }
}
