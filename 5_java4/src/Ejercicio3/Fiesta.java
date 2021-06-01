package Ejercicio3;

import java.util.ArrayList;

public class Fiesta {
    private ArrayList<Invitados> listaInvitado;
    private ArrayList<FuegosArtificiales> listaFuegosArtificiales;

    public Fiesta(ArrayList<Invitados> listaInvitado, ArrayList<FuegosArtificiales> listaFuegosArtificiales) {
        this.listaInvitado = listaInvitado;
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }

    public void apagarVelas(){
        this.explotarTodos();
        this.repartirTorta();

    }
    public void explotarTodos () {
        for (int i = 0; i<this.listaFuegosArtificiales.size();i++) {
            this.listaFuegosArtificiales.get(i).explotar();
        }
    }
    public void repartirTorta(){
        for (int i=0;i<this.listaInvitado.size();i++){
            this.listaInvitado.get(i).comerTorta();
        }
    }


}
