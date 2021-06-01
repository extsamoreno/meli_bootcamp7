package Ex3;

import java.util.ArrayList;
import java.util.List;

public class PackFuegosArtificiales implements FuegosArtificiales{

    private List<FuegosArtificiales> fuegosArtificialesList;

    public PackFuegosArtificiales() {
        this.fuegosArtificialesList = new ArrayList<>();
    }

    public void add(FuegosArtificiales fa) {
        this.fuegosArtificialesList.add(fa);
    }

    public void remove(FuegosArtificiales fa) {
        fuegosArtificialesList.remove(fa);
    }

    @Override
    public void explotar() {
        for (FuegosArtificiales fa : this.fuegosArtificialesList) {
            fa.explotar();
        }
    }

}
