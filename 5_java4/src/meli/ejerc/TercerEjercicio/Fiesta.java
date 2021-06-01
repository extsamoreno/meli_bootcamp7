package meli.ejerc.TercerEjercicio;

import java.util.List;

public class Fiesta {
    private List<Invitado> invitadoList;
    private List<FuegoArtificial> fuegoArtificialList;

    public Fiesta() {
    }

    public Fiesta(List<Invitado> invitadoList, List<FuegoArtificial> fuegoArtificialList) {
        this.invitadoList = invitadoList;
        this.fuegoArtificialList = fuegoArtificialList;
    }

    public void apagarVela(){
        for(FuegoArtificial fa : fuegoArtificialList){
            fa.explotar();
        }
    }

    public void cortarTortaYComer(){
        for(Invitado invitado : invitadoList){
            if (invitado.isEsMeli()) {
                invitado.gritar();
            }
        }
    }



}
