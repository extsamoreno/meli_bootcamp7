package Ejercicio3;

import java.util.ArrayList;

public class PackFuegos {

    public ArrayList<FuegosArtificiales> listaFuegosArtificiales = new ArrayList<>();


    public PackFuegos(ArrayList<FuegosArtificiales> listaFuegosArtificiales) {
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }

    public ArrayList<FuegosArtificiales> getListaFuegosArtificiales() {
        return listaFuegosArtificiales;
    }

    public void setListaFuegosArtificiales(ArrayList<FuegosArtificiales> listaFuegosArtificiales) {
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }


}