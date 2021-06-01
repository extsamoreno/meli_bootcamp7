package Excercise3;

import java.util.ArrayList;

public class FuegoPack implements FuegosArtificiales {
    ArrayList<FuegosArtificiales> fuegos;

    public FuegoPack() {
        this.fuegos = new ArrayList<>();
    }

    public FuegoPack(ArrayList<FuegosArtificiales> fuegos) {
        this.fuegos = fuegos;
    }

    public void addFuego(FuegosArtificiales f) {
        fuegos.add(f);
    }

    @Override
    public void explotar() {
        for (FuegosArtificiales fuego : fuegos
        ) {
            fuego.explotar();
        }
    }
}
