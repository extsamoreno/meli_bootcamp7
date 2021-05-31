package ej3.models;

import ej3.interfaces.FuegosArtificiales;
import ej3.interfaces.Pirotecnia;

import java.util.ArrayList;
import java.util.List;

public class Fiesta {
    private List<Invitado> lMeli = new ArrayList<Invitado>();
    private List<Invitado> lStandar = new ArrayList<Invitado>();
    private List<Pirotecnia> lPirotecnia = new ArrayList<Pirotecnia>();

    public void addInvitado(Invitado invitado) {
        if(invitado.esMeli){
            lMeli.add(invitado);
        } else {
            lStandar.add(invitado);
        }
    }

    public void setlPirotecnia(List<Pirotecnia> lPirotecnia) {
        this.lPirotecnia = lPirotecnia;
    }

    public ArrayList<Pirotecnia> getListaFuegosArtificiales(){
        var lista = new ArrayList<Pirotecnia>();
        for (Pirotecnia P:this.lPirotecnia
             ) {
            lista.addAll(P.listarFuegosArtificiales());
        }
        return lista;
    }

    public void explotarFuegos(){
        getListaFuegosArtificiales().forEach(f->{((FuegosArtificiales)f).explotar();});
    }

    public void seApagaronLasVelas(){
        this.explotarFuegos();
        lMeli.forEach(i-> System.out.println("Viva la Chiqui!"));
    }


}
