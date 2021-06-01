package Excercise3;

import java.util.ArrayList;

public class Evento {
    ArrayList<Invitados> invitados;
    ArrayList<FuegosArtificiales> fuegosArtificiales;


    public Evento() {
        this.invitados = new ArrayList<>();
        this.fuegosArtificiales = new ArrayList<>();
    }

    public Evento(ArrayList<Invitados> invitados, ArrayList<FuegosArtificiales> fuegosArtificiales) {
        this.invitados = invitados;
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public void addInvitado(Invitados invitados) {
        this.invitados.add(invitados);
    }

    public void apagarVelas() {
        System.out.println("La chiqui apago las velas");
        explotarTodo();
        repartirTorta();
    }

    public void explotarTodo() {
        for (FuegosArtificiales fuego : this.fuegosArtificiales
        ) {
            fuego.explotar();
        }
    }

    public void repartirTorta() {
        for (Invitados invitados : this.invitados
        ) {
            invitados.comerTorta();
        }
    }

    public void addFuego(FuegosArtificiales fuegosArtificiales) {
        this.fuegosArtificiales.add(fuegosArtificiales);
    }

    public ArrayList<Invitados> getInvitados() {
        return invitados;
    }

    public void setInvitados(ArrayList<Invitados> invitados) {
        this.invitados = invitados;
    }

    public ArrayList<FuegosArtificiales> getFuegosArtificiales() {
        return fuegosArtificiales;
    }

    public void setFuegosArtificiales(ArrayList<FuegosArtificiales> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }
}
