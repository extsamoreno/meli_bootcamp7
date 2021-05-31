package com.meli;

import java.util.ArrayList;

public class Evento {
    ArrayList<Invitado> invitados;
    ArrayList<FuegoArtificial> fuegosArtificiales;

    public Evento(ArrayList<Invitado> invitados, ArrayList<FuegoArtificial> fuegosArtificiales) {
        this.invitados = invitados;
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public Evento() {
        this.invitados= new ArrayList<>();
        this.fuegosArtificiales= new ArrayList<>();
    }

    public void addInvitado(Invitado invi){
        this.invitados.add(invi);
    }

    public void addFuego(FuegoArtificial fuego){
        this.fuegosArtificiales.add(fuego);
    }

    public void apagarVelas(){
        System.out.println("La Chiqui apago las velas");
        explotarTodo();
        distribuirTorta();

    }

    private void explotarTodo(){
        for (FuegoArtificial fuegos : this.fuegosArtificiales) {
            fuegos.explotar();
        }
    }

    private void distribuirTorta(){
        for (Invitado inv : this.invitados) {
            inv.comerTorta();
        }
    }
}