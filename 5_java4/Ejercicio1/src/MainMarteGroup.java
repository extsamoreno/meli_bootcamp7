import java.util.ArrayList;
import java.util.List;

public class MainMarteGroup {

    public static void main(String[] args) {
        FuegoArtificial fuegoArtificial1 = new FuegoArtificialA();
        FuegoArtificial fuegoArtificial2 = new FuegoArtificialB();
        FuegoArtificial fuegoArtificial3 = new FuegoArtificialC();
        FuegoArtificial fuegoArtificial4 = new FuegoArtificialA();
        FuegoArtificial fuegoArtificial5 = new FuegoArtificialB();
        FuegoArtificial fuegoArtificial6 = new FuegoArtificialC();
        FuegoArtificial fuegoArtificial7 = new FuegoArtificialA();
        FuegoArtificial fuegoArtificial8 = new FuegoArtificialB();
        FuegoArtificial fuegoArtificial9 = new FuegoArtificialC();


        PaqueteFuegoArtificial paquetePadre = new PaqueteFuegoArtificial();
        PaqueteFuegoArtificial paqueteHijoA = new PaqueteFuegoArtificial();
        PaqueteFuegoArtificial paqueteHijoB = new PaqueteFuegoArtificial();
        PaqueteFuegoArtificial paqueteNieto = new PaqueteFuegoArtificial();

        paqueteNieto.agregar(fuegoArtificial1);
        paqueteNieto.agregar(fuegoArtificial2);

        paqueteHijoA.agregar(fuegoArtificial3);
        paqueteHijoB.agregar(fuegoArtificial4);
        paqueteHijoB.agregar(paqueteNieto);

        paquetePadre.agregar(paqueteHijoA);
        paquetePadre.agregar(paqueteHijoB);
        paquetePadre.agregar(fuegoArtificial5);
        paquetePadre.agregar(fuegoArtificial6);

        List<Invitado> listaInvitado = new ArrayList<>();
        listaInvitado.add(new InvitadoMeli());
        listaInvitado.add(new InvitadoStandard());
        listaInvitado.add(new InvitadoMeli());
        listaInvitado.add(new InvitadoStandard());
        listaInvitado.add(new InvitadoMeli());
        listaInvitado.add(new InvitadoStandard());
        listaInvitado.add(new InvitadoMeli());
        listaInvitado.add(new InvitadoStandard());


        System.out.println("Van a estallar los fuegos artificiales: ");
        paquetePadre.explotar();

        System.out.println("*Sirven la porcion de torta");
        listaInvitado.forEach((v) -> {
            if (v instanceof InvitadoMeli){
                System.out.print("Un invitado de Meli dice: ");
            }else{
                System.out.print("Un invitado estandar dice: ");
            }
            v.degustar();
        });





    }

}
