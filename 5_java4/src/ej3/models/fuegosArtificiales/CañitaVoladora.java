package ej3.models.fuegosArtificiales;

import ej3.interfaces.FuegosArtificiales;
import ej3.interfaces.Pirotecnia;

import java.util.ArrayList;
import java.util.List;

public class CañitaVoladora implements FuegosArtificiales {
    @Override
    public String getExplosion() {
        return "fiiiiiiuuuuuumm puM!!!";
    }


}
