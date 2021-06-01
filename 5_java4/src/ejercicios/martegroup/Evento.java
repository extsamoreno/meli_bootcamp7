package ejercicios.martegroup;

import java.util.ArrayList;

public class Evento {
    private ArrayList<Invitado> listaDeInvitados;
    private ArrayList<FuegoArtificial> listaFA;

    public Evento(ArrayList<Invitado> listaDeInvitados, ArrayList<FuegoArtificial> listaFA) {
        this.listaDeInvitados = listaDeInvitados;
        this.listaFA = listaFA;
    }

    public void cargarInvitadoMeli(InvitadoMeli invitadoMeli){
        this.listaDeInvitados.add(invitadoMeli);
    }

    public void cargarInvitadoStandard(InvitadoStandard invitadoStandard){
        this.listaDeInvitados.add(invitadoStandard);
    }


    private void showFuegosArtificiales(){
        for (FuegoArtificial fuegoArtificial : this.listaFA){
            fuegoArtificial.explotar();
        }
    }

    private void comerTorta(){
        for (int i = 0; i < listaDeInvitados.size(); i++) {
            if ( listaDeInvitados.get(i) instanceof InvitadoMeli){
                System.out.println("Viva la Chiqui!!!!");
            }else{
                System.out.println("Que rica torta...");
            }
        }
    }
    public void soplarVelas(){
        System.out.println("La chiqui sopla las velas!!!!");
        showFuegosArtificiales();
        comerTorta();
    }

}
