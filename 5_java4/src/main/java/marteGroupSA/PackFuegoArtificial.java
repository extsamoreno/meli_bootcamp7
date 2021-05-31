package marteGroupSA;

import java.util.ArrayList;

public class PackFuegoArtificial implements FuegoArtificial{

    ArrayList<FuegoArtificial> fuegosArtificiales = new ArrayList<>();

    public PackFuegoArtificial(ArrayList<FuegoArtificial> fuegosArtificiales){
        this.fuegosArtificiales = fuegosArtificiales;
    }

    @Override
    public void hacerRuido() {
        fuegosArtificiales.stream().forEach(fuegoArtificial -> {
            fuegoArtificial.hacerRuido();
        });
    }
}
