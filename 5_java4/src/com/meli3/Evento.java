package com.meli3;

import java.util.ArrayList;

public class Evento {
    private ArrayList<Invitados> listaInvitados;
    private ArrayList<Pirotecnia> pirotecnias;
    private boolean velaPrendida;

    public Evento(ArrayList<Invitados> listaInvitados, ArrayList<Pirotecnia> pirotecnias) {
        this.velaPrendida = true;
        this.pirotecnias = pirotecnias;
        this.listaInvitados = listaInvitados;
    }

    public void laChiquiApagaVela() {
        for (Pirotecnia p: this.pirotecnias) {
            p.accionar();
        }
        for (Invitados i: listaInvitados) {
            i.comerPastel();
        }
    }

    public ArrayList<Invitados> getListaInvitados() {
        return listaInvitados;
    }

    public void setListaInvitados(ArrayList<Invitados> listaInvitados) {
        this.listaInvitados = listaInvitados;
    }

    public ArrayList<Pirotecnia> getPirotecnias() {
        return pirotecnias;
    }

    public void setPirotecnias(ArrayList<Pirotecnia> pirotecnias) {
        this.pirotecnias = pirotecnias;
    }

    public boolean isVelaPrendida() {
        return velaPrendida;
    }
}
