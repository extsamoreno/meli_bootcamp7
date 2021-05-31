package com.meli.tm.ex3;

import java.util.ArrayList;
import java.util.List;

public class MainEvento {

    public static void main(String[] args) {

        String[] arrInvitadosMeli = {"Jhader", "Alexis", "Luis", "Jorge", "Danilo"};
        String[] arrInvitadosStandar = {"Carlos", "Pedro", "Santiago"};

        List<Invitado> listaInvitados = new ArrayList<>();
        List<FuegoArtificial> fuegoArtificials = new ArrayList<>();
        Integer nroEmpleado = 1000;
        for (String nombre : arrInvitadosMeli
        ) {
            listaInvitados.add(new InvitadoMeli(nombre, nroEmpleado));
            nroEmpleado++;
        }

        for (String nombre : arrInvitadosStandar
        ) {
            listaInvitados.add(new InvitadoStandar(nombre));
        }

        fuegoArtificials.add(new FuegoArtificialSimple());
        fuegoArtificials.add(new FuegoArtificialSimple());
        fuegoArtificials.add(new FuegoArtificialSimple());
        fuegoArtificials.add(new FuegoArtificialSimple());
        List<FuegoArtificial> otrosFuegosArtificiales = new ArrayList<>();
        otrosFuegosArtificiales.add(new FuegoArtificialSimple());
        otrosFuegosArtificiales.add(new FuegoArtificialSimple());
        otrosFuegosArtificiales.add(new FuegoArtificialSimple());
        otrosFuegosArtificiales.add(new FuegoArtificialSimple());
        fuegoArtificials.add(new FuegoArtificialMultiple(otrosFuegosArtificiales));




        Evento eventoMarteGroup = new Evento(listaInvitados, fuegoArtificials);
        eventoMarteGroup.apagarVelas();


    }
}
