package Ejercicio3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Evento marteGroup = new Evento();

        marteGroup.addInvitado(new InvitadoMeli());
        marteGroup.addInvitado(new InvitadoStandard());

        marteGroup.addFugo(new FuegoArtificialA());
        marteGroup.addFugo(new FuegoArtificialA());
        marteGroup.addFugo(new FuegoArtificialB());
        marteGroup.addFugo(new FuegoArtificialB());


        ArrayList<IFuegoArtificial> arr = new ArrayList<>();
        arr.add(new FuegoArtificialA());
        arr.add(new FuegoArtificialB());
        arr.add(new FuegoArtificialC());

        PackFuegoMixto pack = new PackFuegoMixto(arr);

        PackFuegoMixto packMixto = new PackFuegoMixto();
        packMixto.add(new FuegoArtificialC());
        packMixto.add(pack);

        PackFuegoMixto packMixto2 = new PackFuegoMixto();
        packMixto2.add(packMixto);
        packMixto2.add(new FuegoArtificialA());

        marteGroup.addFugo(pack);
        marteGroup.addFugo(packMixto2);
        marteGroup.apagarVelas();
    }
}
