package com.company;

import java.util.ArrayList;

public class Evento<T> {
    private ArrayList<Invitado> listaInvitados;
    private PackFuegos<T> listaFuegos;

    public Evento() {
        this.listaInvitados = new ArrayList<>();
        this.listaFuegos = new PackFuegos<T>();
    }

    public void agregarListaInvitado(Invitado nuevoInvitado){
        listaInvitados.add(nuevoInvitado);
    }

    public void agregarListaFuegos(T fuego){
        listaFuegos.agregarFuegoAlPack(fuego);
    }

    public void apagarVelas(){
        // Explotar fuegos artificiales
        listaFuegos.explotar();

        // Invitados gritan
        for (Invitado person: listaInvitados) {
            person.gritar();
        }
    }
}
