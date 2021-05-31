package com.company;

public class Main {

    public static void main(String[] args) {

        // Crear Evento
        Evento centenario = new Evento();

        // Crear Invitados
        Invitado in1 = new InvitadoMeli();
        Invitado in2 = new InvitadoStd();
        Invitado in3 = new InvitadoMeli();
        Invitado in4 = new InvitadoStd();
        Invitado in5 = new InvitadoMeli();
        Invitado in6 = new InvitadoStd();

        // Agregar a lista de invitados
        centenario.agregarListaInvitado(in1);
        centenario.agregarListaInvitado(in2);
        centenario.agregarListaInvitado(in3);
        centenario.agregarListaInvitado(in4);
        centenario.agregarListaInvitado(in5);
        centenario.agregarListaInvitado(in6);

        // Crear Fuegos
        Fuego f1 = new Fuego("PAM");
        Fuego f2 = new Fuego("PEM");
        Fuego f3 = new Fuego("PIM");
        Fuego f4 = new Fuego("POM");
        Fuego f5 = new Fuego("PUM");

        // Crear packs de Fuegos
        // PACK1
        PackFuegos pack1 = new PackFuegos();
        pack1.agregarFuegoAlPack(f1);
        pack1.agregarFuegoAlPack(f2);
        pack1.agregarFuegoAlPack(f3);
        pack1.agregarFuegoAlPack(f4);
        pack1.agregarFuegoAlPack(f5);

        // PACK2
        PackFuegos pack2 = new PackFuegos();
        pack2.agregarFuegoAlPack(f1);
        pack2.agregarFuegoAlPack(f3);
        pack2.agregarFuegoAlPack(f5);

        // PACK3
        PackFuegos pack3 = new PackFuegos();
        pack3.agregarFuegoAlPack(f1);
        pack3.agregarFuegoAlPack(pack1);
        pack3.agregarFuegoAlPack(pack2);

        // Agregar los fuegos a la lista de fuegos del evento
        centenario.agregarListaFuegos(f1);
        centenario.agregarListaFuegos(null);
        centenario.agregarListaFuegos(pack1);
        centenario.agregarListaFuegos(pack3);

        System.out.println("Centenario de “La Chiqui” Legrand");
        System.out.println(" ");
        System.out.println("Momento de soplar las velas:");
        centenario.apagarVelas();

    }
}
