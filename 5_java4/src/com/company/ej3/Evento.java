package com.company.ej3;

import java.util.List;

public class Evento {

    List<Invitado> invitados;
    List<Component> fuegosArtificiales;

    public Evento(List<Invitado> invitados, List<Component> fuegosArtificiales) {
        this.invitados = invitados;
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public void horaDeLaTorta() {
        lanzarFuegos();
        System.out.println();
        repartirTorta();
    }

    private void lanzarFuegos() {
        for (Component c :fuegosArtificiales) {
            c.explotar();
        }
    }

    private void repartirTorta() {
        for (Invitado i : this.invitados) {
            i.comerTorta();
        }
    }

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<Invitado> invitados) {
        this.invitados = invitados;
    }

    public List<Component> getFuegosArtificiales() {
        return fuegosArtificiales;
    }

    public void setFuegosArtificiales(List<Component> fuegosArtificiales) {
        this.fuegosArtificiales = fuegosArtificiales;
    }
}
