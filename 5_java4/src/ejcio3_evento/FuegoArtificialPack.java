package ejcio3_evento;

import java.util.ArrayList;
import java.util.List;

public class FuegoArtificialPack extends FuegoArtificial {
    public FuegoArtificialPack(String id) {
        super(id);
        this.fuegosArtificiales = new ArrayList<>();
    }


    private List<FuegoArtificial> fuegosArtificiales;
    //Constructor

    // Getters & Setters
    public List<FuegoArtificial> getFuegosArtificiales() {
        return fuegosArtificiales;
    }

    public void setFuegosArtificiales(List<FuegoArtificial> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }

    @Override
    public void explotar() {
        for(FuegoArtificial f : fuegosArtificiales){
            f.explotar();
        }
    }

    @Override
    public void mostrarId() {
        for(FuegoArtificial f : fuegosArtificiales){
            f.mostrarId();
        }
    }
}
