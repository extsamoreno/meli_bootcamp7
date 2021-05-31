package Ejercicio3;

import java.util.ArrayList;

public class Evento {

    private ArrayList<IInvitado> listInvitado = new ArrayList<>();
    private ArrayList<IFuegoArtificial> listFuegos = new ArrayList<>();

    public Evento() {
    }

    public void addInvitado(IInvitado invitado){
        this.listInvitado.add(invitado);
    }

    public void apagarVelas(){
        this.fuego();
        this.degustar();
    }

    private void degustar() {
        for (IInvitado iv: listInvitado) {
            iv.degustar();
        }
    }

    public void addFugo(IFuegoArtificial fuegoArtificial){
        this.listFuegos.add(fuegoArtificial);
    }

    public void fuego(){
        for (IFuegoArtificial f: listFuegos) {
            f.explotar();
        }
    }



}
