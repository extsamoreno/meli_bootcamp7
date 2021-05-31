import java.util.ArrayList;

public class Evento {
    ArrayList<Invitado> invitados;
    ArrayList<IFuegoArtifical> fuegosArtificio;

    public Evento(){
        this.invitados = new ArrayList<>();
        this.fuegosArtificio = new ArrayList<>();
    }

    public Evento(ArrayList<Invitado> invitados, ArrayList<IFuegoArtifical> fuegosArtificio) {
        this.invitados = invitados;
        this.fuegosArtificio = fuegosArtificio;
    }

    public void agregarinvitado(Invitado invitado){
        this.invitados.add(invitado);
    }

    public void agregarFuego(IFuegoArtifical fuego){
        this.fuegosArtificio.add(fuego);
    }

    public void explotarFuegos(){
        for(IFuegoArtifical fuego: this.fuegosArtificio){
            fuego.explotar();
        }
    }

    public void comerTorta(){
        for (Invitado invitado: invitados){
            invitado.comerTorta();
        }
    }

    public void apagarVelas(){
        System.out.println("La chiqui apago las velas");
        explotarFuegos();
        comerTorta();
    }
}
