import java.util.List;

public abstract class FuegoArtificialMultiple implements FuegoArtificial{
    
    private List<FuegoArtificial> fuegosArtificiales;

    public FuegoArtificialMultiple(List<FuegoArtificial> fuegosArtificiales){

        this.fuegosArtificiales = fuegosArtificiales;

    }

    public void explotar(){

        for (int i = 0; i < this.fuegosArtificiales.size(); i++) {
            this.fuegosArtificiales.get(i).explotar();
        }
    }

    public List<FuegoArtificial> getUnidades() {
        return fuegosArtificiales;
    }


    public void setUnidades(List<FuegoArtificial> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }

}
