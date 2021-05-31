package com.company.ej3;

import java.util.ArrayList;

public class PackFuegosArtificiales extends FuegoArtificial{

    ArrayList<FuegoArtificial> listaFuegosArtificiales;

    public PackFuegosArtificiales(ArrayList<FuegoArtificial> listaFuegosArtificiales) {
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }

    @Override
    public void accionar() {

        for (FuegoArtificial f : listaFuegosArtificiales) {
            if(f instanceof FuegoArtificialIndividual){
                ((FuegoArtificialIndividual) f).getTipoRuido();
            }
        }
    }
}
