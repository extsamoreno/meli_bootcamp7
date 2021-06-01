package com.meli.parte3;

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
        System.out.println("chiqui apago las velas");
        explotarTodo();
        aComer();

    }

    private void explotarTodo(){
        for (FuegoArtificial fuegos: this.fuegosArtificiales
        ) {
            fuegos.explotar();
        }
    }

    private void aComer(){
        for (Invitado inv: this.invitados
        ) {
            inv.comerTorta();
        }
    }

}
