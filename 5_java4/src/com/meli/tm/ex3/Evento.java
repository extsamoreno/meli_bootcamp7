package com.meli.tm.ex3;

import java.util.ArrayList;
import java.util.List;

public class Evento {

    private List<Invitado> listaInvitados;
    private List<FuegoArtificial> fuegosArtificiales;

    public Evento(List<Invitado> listaInvitados, List<FuegoArtificial> fuegosArtificiales) {
        this.listaInvitados = listaInvitados;
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public void apagarVelas() {
        lanzarFuegosArtificiales();
        repartirTorta();
    }

    private void lanzarFuegosArtificiales() {
        for (FuegoArtificial fuegoArtificial : fuegosArtificiales
        ) {
            fuegoArtificial.explotar();
        }
    }

    public void repartirTorta() {
        for (Invitado invitado : listaInvitados) {
            invitado.comer();
        }
    }

}
