package ej3.models.fuegosArtificiales;

import ej3.interfaces.FuegosArtificiales;
import ej3.interfaces.Pirotecnia;

import java.util.ArrayList;
import java.util.List;

public class Pack implements ej3.interfaces.Pack {
    private List<Pirotecnia> lFuegosArt= new ArrayList<Pirotecnia>();


    @Override
    public void addFuegoArt(Pirotecnia fuegoArt) {
        lFuegosArt.add(fuegoArt);
    }

    @Override
    public List<Pirotecnia> listarFuegosArtificiales() {
        var listaLocal = new ArrayList<Pirotecnia>();
        for (Pirotecnia P: this.lFuegosArt
             ) {
            listaLocal.addAll(P.listarFuegosArtificiales());
        }
        return listaLocal;
    }
}
