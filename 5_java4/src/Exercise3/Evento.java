package Exercise3;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private List<Invitado> invitados;
    private List<FuegoArtificial> fuegosArtificiales;
    private String nombre;

    public Evento(String nombre) {
        this.nombre = nombre;
        invitados = new ArrayList<>();
        fuegosArtificiales = new ArrayList<>();
    }



    public List<Invitado> getInvitados() {
        return invitados;
    }

    public List<FuegoArtificial> getFuegosArtificiales() {
        return fuegosArtificiales;
    }

    public void apagarVelas(){
        for (FuegoArtificial fuego : fuegosArtificiales){
            fuego.explotar();
        }
        for(Invitado invitado : invitados){
            invitado.comer();
        }
    }
}
