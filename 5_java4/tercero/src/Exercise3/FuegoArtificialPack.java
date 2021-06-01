package Exercise3;

import java.util.ArrayList;
import java.util.List;

public class FuegoArtificialPack extends FuegoArtificial {
    public List<FuegoArtificial> getFuegosArtificiales() {
        return fuegosArtificiales;
    }

    public void setFuegosArtificiales(List<FuegoArtificial> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }

    private List<FuegoArtificial> fuegosArtificiales;
    public FuegoArtificialPack(String id){
        super(id);
        fuegosArtificiales = new ArrayList<>();
    }

    @Override
    public void explotar() {
        for(FuegoArtificial fuego : fuegosArtificiales){
            fuego.explotar();
        }
    }
}
