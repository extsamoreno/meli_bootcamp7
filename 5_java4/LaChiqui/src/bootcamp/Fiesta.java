package bootcamp;

import java.util.ArrayList;

public class Fiesta {

    private final ArrayList<Invitado> invitados = new ArrayList<>();
    private final ArrayList<FuegoArtificialI> fuegos = new ArrayList<>();

    public void apagarVela(){
        for(FuegoArtificialI x: fuegos){
            x.explotar();
        }
    }

    public void cortarTorta(){
        for( Invitado x:invitados){
            x.alabarMirta();
        }
    }

    public void addInvitados( String name, boolean esMeli){
        invitados.add(new Invitado(name, esMeli));
    }

    public void addFuego(FuegoArtificialI fuego){
        this.fuegos.add(fuego);
    }


}
