import java.util.List;

public class Evento {
    public static int contarFuegosArtificiales(List<FuegosArtificiales> x){
        int contador=0;
        for (int i = 0; i < x.size(); i++) {
            if(x instanceof FuegosArtificialesIndiv) contador++;
            if(x instanceof FuegosArtificialesPack) contador+=((FuegosArtificialesPack) x).getListaFuegArt().size();
        }
        return contador;
    }

    public static void gritar(List<Invitado> x){
        for (int i = 0; i < x.size(); i++) {
            if (x instanceof InvitadoMELI) ((InvitadoMELI) x).comerTorta();
        }
    }
}
