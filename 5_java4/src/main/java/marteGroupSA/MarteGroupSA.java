package marteGroupSA;

import java.util.ArrayList;

public class MarteGroupSA {

    private ArrayList<FuegoArtificial> fuegosArtificiales = new ArrayList<>();
    private ArrayList<Invitado> invitados = new ArrayList<>();

    public void reventarFuegosArtificiales() {
        fuegosArtificiales.stream().forEach(fuegoArtificial -> {
            fuegoArtificial.hacerRuido();
        });
    }

    public void repartirTorta() {
        invitados.stream().forEach(invitado -> {
            invitado.comerTorta();
        });
    }

    public void setFuegosArtificiales(ArrayList<FuegoArtificial> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public void setInvitados(ArrayList<Invitado> invitados) {
        this.invitados = invitados;
    }
}
