package Exercise3;

public class Main {
    public static void main(String[] args) {


        Evento chiqui = new Evento("La chiqui");

        Organizacion marte = new Organizacion(chiqui,"Marte");

        chiqui.getInvitados().add(new InvitadoMeli("1"));
        chiqui.getInvitados().add(new InvitadoStandard("1"));
        chiqui.getInvitados().add(new InvitadoMeli("1"));
        chiqui.getInvitados().add(new InvitadoStandard("1"));

        chiqui.getFuegosArtificiales().add(new FuegoArtificialIndividual("12","boom"));
        chiqui.getFuegosArtificiales().add(new FuegoArtificialIndividual("12","boom"));
        chiqui.getFuegosArtificiales().add(new FuegoArtificialIndividual("12","bum"));
        chiqui.getFuegosArtificiales().add(new FuegoArtificialIndividual("12","bim"));

        FuegoArtificialPack pack = new FuegoArtificialPack("a");
        pack.getFuegosArtificiales().add(new FuegoArtificialIndividual("2","plop"));
        pack.getFuegosArtificiales().add(new FuegoArtificialIndividual("2","plup"));
        pack.getFuegosArtificiales().add(new FuegoArtificialIndividual("2","plap"));

        FuegoArtificialPack pack2 = new FuegoArtificialPack("b");
        pack2.getFuegosArtificiales().add(pack);
        pack2.getFuegosArtificiales().add(pack);

        chiqui.getFuegosArtificiales().add(new FuegoArtificialIndividual("3","fiuf"));
        chiqui.getFuegosArtificiales().add(pack);
        chiqui.getFuegosArtificiales().add(pack2);

        chiqui.apagarVelas();
    }
}
