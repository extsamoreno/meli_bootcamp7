package ejcio3_evento;

import java.util.List;

public class Evento {

    private List<Invitado> invitados;
    private List<FuegoArtificial> fuegosArtificiales;

    //Getters & Setters
    public List<Invitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<Invitado> invitados) {
        this.invitados = invitados;
    }

    public List<FuegoArtificial> getFuegosArtificiales() {
        return fuegosArtificiales;
    }

    public void setFuegosArtificiales(List<FuegoArtificial> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }

    // Constructores

    public Evento(List<FuegoArtificial> fuegosArtificiales, List<Invitado> invitados) {
        this.fuegosArtificiales = fuegosArtificiales;
        this.invitados = invitados;
    }

    public Evento() {
    }

}
