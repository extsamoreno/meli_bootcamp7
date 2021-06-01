package bootcamp;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Fiesta laChiqui = new Fiesta();

        FuegoArtificial fuego1 = new FuegoArtificial("pum");
        FuegoArtificial fuego2 = new FuegoArtificial( "pim");
        FuegoArtificial fuego3 = new FuegoArtificial( "pam");
        Pack pack1 = new Pack();
        pack1.addFuego( fuego1 );
        pack1.addFuego( fuego2 );
        Pack pack2 = new Pack( );
        pack2.addFuego( fuego3 );
        pack2.addPack( pack1 );



        laChiqui.addInvitados("Gian", true);
        laChiqui.addInvitados("Matias", false);
        laChiqui.addFuego(fuego1);
        laChiqui.addFuego(fuego3);
        laChiqui.addFuego(pack1);
        laChiqui.addFuego(pack2);

        laChiqui.apagarVela();
        laChiqui.cortarTorta();
    }
}
