package martegroupsa;

import java.util.ArrayList;

public class Evento {
    ArrayList<martegroupsa.Invitado> invitados;
    ArrayList<martegroupsa.FuegoArtificial> fuegosArtificiales;

    public Evento(ArrayList<martegroupsa.Invitado> invitados, ArrayList<martegroupsa.FuegoArtificial> fuegosArtificiales) {
        this.invitados = invitados;
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public Evento() {
        this.invitados = new ArrayList<>();
        this.fuegosArtificiales = new ArrayList<>();
    }

    public void agregarInvitado(martegroupsa.Invitado invitado){
        this.invitados.add(invitado);
    }

    public void agregarFuegoArtifical(martegroupsa.FuegoArtificial fuegoArtificial){
        this.fuegosArtificiales.add(fuegoArtificial);
    }

    public void apagarVelas(){
        System.out.println("La Chiqui apago las velas");
        explotarTodo();
        distribuirTorta();

    }

    private void explotarTodo(){
        for (martegroupsa.FuegoArtificial fuegoArtificial : this.fuegosArtificiales) {
            fuegoArtificial.explotar();
        }
    }

    private void distribuirTorta(){
        for (martegroupsa.Invitado invitado : this.invitados) {
            invitado.comerTorta();
        }
    }
}