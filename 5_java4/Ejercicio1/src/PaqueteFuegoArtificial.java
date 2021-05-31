import java.util.ArrayList;
import java.util.List;

public class PaqueteFuegoArtificial implements FuegoArtificial{

    private List<FuegoArtificial> listaFuegosArtificiales;
    //private List<List<PaqueteFuegoArtificial>> paqueteFuegoArtificiales;


    public PaqueteFuegoArtificial() {
        listaFuegosArtificiales = new ArrayList<>();
    }

    @Override
    public void explotar() {
        for (FuegoArtificial listaFuegoArtificial : listaFuegosArtificiales) {
            listaFuegoArtificial.explotar();
        }
    }

    public void obtenerNombre(){

        for (FuegoArtificial fuegoArtificial: listaFuegosArtificiales) {
            if (!(fuegoArtificial instanceof List)){
                System.out.println(fuegoArtificial.getClass());
            }else{
                PaqueteFuegoArtificial paqueteHijo = (PaqueteFuegoArtificial) fuegoArtificial;
                paqueteHijo.obtenerNombre();
            }
        }

    }

    public void agregar(FuegoArtificial fuegoArtificial){
        listaFuegosArtificiales.add(fuegoArtificial);
    }

    public void agregar(PaqueteFuegoArtificial fuegoArtificial){
        listaFuegosArtificiales.add(fuegoArtificial);
    }

    public List<FuegoArtificial> getListaFuegosArtificiales() {
        return listaFuegosArtificiales;
    }

    public void setListaFuegosArtificiales(List<FuegoArtificial> listaFuegosArtificiales) {
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }
}
