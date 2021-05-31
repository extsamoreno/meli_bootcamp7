package cumpleChiqui;

import java.util.ArrayList;
import java.util.List;

public class FuegosPack extends FuegoArtificial{
    List<FuegoArtificial> fuegoArtificialList;

    public FuegosPack(){
        this.fuegoArtificialList = new ArrayList<>();
    }

    public FuegosPack(List<FuegoArtificial> fuegoArtificialList) {
        this.fuegoArtificialList = fuegoArtificialList;
    }

    @Override
    public void explotar() {
        for(FuegoArtificial fa : fuegoArtificialList){
            fa.explotar();
        }
    }

    public void addFuegos(FuegoArtificial fa){
        this.fuegoArtificialList.add(fa);
    }

    public List<FuegoArtificial> getFuegoArtificialList() {
        return fuegoArtificialList;
    }

    public void setFuegoArtificialList(List<FuegoArtificial> fuegoArtificialList) {
        this.fuegoArtificialList = fuegoArtificialList;
    }
}
