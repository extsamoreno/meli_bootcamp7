package com.meli.tm.ex3;

import java.util.List;

public class FuegoArtificialMultiple implements FuegoArtificial {

    List<FuegoArtificial> listaFuegosArtificiales;

    public FuegoArtificialMultiple(List<FuegoArtificial> listaFuegosArtificiales) {
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }

    @Override
    public void explotar() {
        for (FuegoArtificial fuegoArtificial : listaFuegosArtificiales
        ) {
            fuegoArtificial.explotar();
        }
    }

    public List<FuegoArtificial> getListaFuegosArtificiales() {
        return listaFuegosArtificiales;
    }

    public void setListaFuegosArtificiales(List<FuegoArtificial> listaFuegosArtificiales) {
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }
}
