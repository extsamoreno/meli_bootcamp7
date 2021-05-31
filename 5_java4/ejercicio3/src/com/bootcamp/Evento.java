package com.bootcamp;

import java.util.ArrayList;

public class Evento {

    ArrayList<Invitado> invitados;
    ArrayList<FuegoArtificial> fuegosArtificiales;


    public Evento(ArrayList<Invitado> invitados, ArrayList<FuegoArtificial> fuegosArtificiales) {
        this.invitados = invitados;
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public Evento() {
        this.invitados = new ArrayList<>();
        this.fuegosArtificiales = new ArrayList<>();
    }

    public void addInvitado(Invitado invi) {
        this.invitados.add(invi);
    }

    public void addFuego(FuegoArtificial fuego) {
        this.fuegosArtificiales.add(fuego);
    }

    public void apagarVelas() {
        System.out.println("La Chiqui apagó las velas");
        explotarTodo();
        aComer();
    }

    private void explotarTodo() {
        System.out.println("Comienzan los fuegos artificiales");
        for (FuegoArtificial fuegos : this.fuegosArtificiales) {
            fuegos.explotar();
        }
        System.out.println("Finalizan los fuegos artificiales");
    }

    private void aComer() {
        System.out.println("Se reparte la torta a los invitados");
        for (Invitado inv : this.invitados) {
            inv.comerTorta();
        }
    }

}
