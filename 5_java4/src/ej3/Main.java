package ej3;

import ej3.interfaces.Pirotecnia;
import ej3.models.Fiesta;
import ej3.models.Invitado;
import ej3.models.fuegosArtificiales.BombaDeEstruendo;
import ej3.models.fuegosArtificiales.CañitaVoladora;
import ej3.models.fuegosArtificiales.Pack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var invitado1 = new Invitado("pepe",true);
        var invitado2 = new Invitado("jose",true);
        var invitado3 = new Invitado("maria",false);
        var invitado4 = new Invitado("carlos",true);

        var listaInvitados = new ArrayList<Invitado>(List.of(invitado1,invitado2,invitado3,invitado4));

        var fuego1 = new CañitaVoladora();
        var fuego2 = new CañitaVoladora();
        var fuego3 = new BombaDeEstruendo();

        var pack1 = new Pack();
        pack1.addFuegoArt(fuego2);
        pack1.addFuegoArt(fuego3);

        var pack2 = new Pack();
        pack2.addFuegoArt(fuego3);
        pack2.addFuegoArt(pack1);

        Fiesta fiesta = new Fiesta();
        fiesta.setlPirotecnia(List.of(pack1,pack2,fuego3,fuego1,fuego1,fuego2));
        listaInvitados.forEach(fiesta::addInvitado);
        fiesta.seApagaronLasVelas();





    }
}
