package com.ejercitacion.m.tercero;

import java.util.ArrayList;
import java.util.List;

public class MainCumpleChiqui {

    public static void main(String[] args) {

        List<Invitado> invitados = new ArrayList<>();
        Invitado invitadoStandard = new InvitadoStandard("Pepe");
        Invitado invitadoMeli = new InvitadoMeli("Roberto");
        invitados.add(invitadoStandard);
        invitados.add(invitadoMeli);
        FuegoArtificial fuego2 = new FuegoArtificial("cañita");
        FuegoArtificial fuego3 = new FuegoArtificial("estrellita");

        List<FuegoArtificial> fuegosIndividuales = new ArrayList<>();
        fuegosIndividuales.add(fuego2);
        fuegosIndividuales.add(fuego3);
        List<FuegoArtificial> pack1 = new ArrayList<>();
        pack1.add(fuego2);
        pack1.add(fuego3);
        PackFuegosArtificiales packFuegosArtificiales = new PackFuegosArtificiales();
        packFuegosArtificiales.getFuegosArificiales().add(fuego2);
        packFuegosArtificiales.getFuegosArificiales().add(fuego3);
        PackFuegosArtificiales packFuegosArtificiales2 = new PackFuegosArtificiales();
        packFuegosArtificiales2.getPacks().add(packFuegosArtificiales);
        packFuegosArtificiales2.getFuegosArificiales().addAll(fuegosIndividuales);
        List<PackFuegosArtificiales> packs = new ArrayList<>();
        packs.add(packFuegosArtificiales2);
        List<FuegoArtificial> listaTotal = getListaFuegos(fuegosIndividuales, packs);
        for (FuegoArtificial fuegoArtificial : listaTotal) {
            fuegoArtificial.explotar();
        }
        for (Invitado invitado : invitados) {
           invitado.comerTorta();
        }
    }

    public static List<FuegoArtificial> getListaFuegos(List<FuegoArtificial> fuegosIndividuales, List<PackFuegosArtificiales> listaPacks) {
        List<FuegoArtificial> listaTotal = new ArrayList<>();
        listaTotal.addAll(fuegosIndividuales);
        listaTotal.addAll(recursion(listaPacks));
        return listaTotal;
    }

    private static List<FuegoArtificial> recursion(List<PackFuegosArtificiales> listaPack) {
        List<FuegoArtificial> totalPack = new ArrayList<>();
        for (PackFuegosArtificiales pack : listaPack) {
            totalPack.addAll(pack.getFuegosArificiales());
            if (pack.getPacks().size() > 0) {
                totalPack.addAll(recursion(pack.getPacks()));
            }
        }
        return totalPack;
    }

}
