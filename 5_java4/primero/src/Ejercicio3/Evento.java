package Ejercicio3;

import java.util.ArrayList;

public class Evento {

    ArrayList<PackFuegos> listaFuegosArtificiales = new ArrayList<>();
    ArrayList<Invitado> listaInvitados = new ArrayList<>();
    private InvitadoMELI InvitadoMELI;
    private InvitadoSTANDAR InvitadoSTANDAR;


    public ArrayList<PackFuegos> getListaFuegosArtificiales() {
        return listaFuegosArtificiales;
    }

    public void setListaFuegosArtificiales(ArrayList<PackFuegos> listaFuegosArtificiales) {
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }

    public ArrayList<Invitado> getListaInvitados() {
        return listaInvitados;
    }

    public void setListaInvitados(ArrayList<Invitado> listaInvitados) {
        this.listaInvitados = listaInvitados;
    }

    public void reventarFuegosArtificiales(){

        for(int i =0; i<this.listaFuegosArtificiales.size(); i++){

            PackFuegos pack = listaFuegosArtificiales.get(i);
            if(!pack.getListaFuegosArtificiales().isEmpty()){
                for(int j =0; j<pack.getListaFuegosArtificiales().size(); j++){
                    System.out.println(pack.getListaFuegosArtificiales().get(j).getRuido());
                }
            }
        }
    }

    public void distribuirPorcion(){

        for(int i =0; i<this.listaInvitados.size(); i++) {

            Invitado invitado = this.listaInvitados.get(i);

            if(invitado instanceof InvitadoMELI){
                System.out.println("Viva la chiqui");
            }
        }
    }
}
