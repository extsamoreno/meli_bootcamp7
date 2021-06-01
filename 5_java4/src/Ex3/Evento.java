package Ex3;

import java.util.List;

public class Evento {


    private List<Invitado> invitados;
    private List<FuegosArtificiales> fuegosArtificiales;

    public Evento(List<Invitado> invitados, List<FuegosArtificiales> fuegosArtificiales) {
        this.invitados = invitados;
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<Invitado> invitados) {
        this.invitados = invitados;
    }

    public List<FuegosArtificiales> getFuegosArtificiales() {
        return fuegosArtificiales;
    }

    public void setFuegosArtificiales(List<FuegosArtificiales> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public void partirLaTorta() {
        lanzarFuegos();
        System.out.println();
        repartirTorta();
    }

    private void lanzarFuegos() {
        for (FuegosArtificiales fa :fuegosArtificiales) {
            fa.explotar();
        }
    }

    private void repartirTorta() {
        for (Invitado i : this.invitados) {
            i.comerTorta();
        }
    }


}
