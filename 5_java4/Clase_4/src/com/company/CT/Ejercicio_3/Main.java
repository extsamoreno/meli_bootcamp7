package com.company.CT.Ejercicio_3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        FuegosArtificiales f1 = new FuegosArtificiales("PUM");
        FuegosArtificiales f2 = new FuegosArtificiales("PAM");
        FuegosArtificiales f3 = new FuegosArtificiales("PIM");

        ArrayList<FuegosArtificiales> lista = new ArrayList<>();
        lista.add(f1);
        lista.add(f2);

        ArrayList<FuegosArtificiales> lista1 = new ArrayList<>();
        lista1.add(f3);

        PackFuegos p1 = new PackFuegos(lista);
        PackFuegos p2 = new PackFuegos(lista1);

        ArrayList<PackFuegos> listapaquetes = new ArrayList<>();
        listapaquetes.add(p1);
        listapaquetes.add(p2);

        Invitado im = new InvitadoMELI();
        Invitado is = new InvitadoSTANDAR();
        ArrayList<Invitado> listaInvitados = new ArrayList<>();

        listaInvitados.add(im);
        listaInvitados.add(is);
        Evento evento = new Evento();

        evento.setListaFuegosArtificiales(listapaquetes);

        evento.setListaInvitados(listaInvitados);
        evento.distribuirPorcion();


    }
}
