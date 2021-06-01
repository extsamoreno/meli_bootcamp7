package Ejercicio3;

import java.util.ArrayList;

public class PackFuegosArtificiales extends FuegosArtificiales{
   private ArrayList<FuegosArtificiales> packFuegosArtificiales;

    public PackFuegosArtificiales() {
        this.packFuegosArtificiales = new ArrayList<>();
    }
    public void agregarFuegosArtificiales (FuegosArtificiales fuegosArtificiales) {
        this.packFuegosArtificiales.add(fuegosArtificiales);
    }

    @Override
    public void explotar() {
        for (int i = 0;i<this.packFuegosArtificiales.size();i++) {
            this.packFuegosArtificiales.get(i).explotar();
        }
    }
}
