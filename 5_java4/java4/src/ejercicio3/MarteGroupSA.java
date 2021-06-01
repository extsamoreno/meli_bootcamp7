package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class MarteGroupSA {
    Chiqui laChiqui = new Chiqui();
    List<Invitado> invitados=new ArrayList<>();
    List<FuegoArtificial> cohetes=new ArrayList<>();

    public MarteGroupSA() {
    }

    public MarteGroupSA(List<Invitado> invitados, List<FuegoArtificial> cohetes) {
        this.invitados = invitados;
        this.cohetes = cohetes;
    }

    public Chiqui getLaChiqui() {
        return laChiqui;
    }

    public void setLaChiqui(Chiqui laChiqui) {
        this.laChiqui = laChiqui;
    }

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<Invitado> invitados) {
        this.invitados = invitados;
    }

    public List<FuegoArtificial> getCohetes() {
        return cohetes;
    }

    public void setCohetes(List<FuegoArtificial> cohetes) {
        this.cohetes = cohetes;
    }


    public void agregarInvitado(Invitado invitado) {
        invitados.add(invitado);
    }

    public void agregarFuegoArtificial(FuegoArtificial cohete) {
        getCohetes().add(cohete);
    }



    public void reventarFuegosArtificiales() {
        cohetes.forEach(elem -> elem.explotar());
    }

    public void distribuirTorta() {
        invitados.forEach(elem -> elem.comerTorta());
    }

    public void festejar(){
        System.out.println("\nChiqui apaga la vela");
        laChiqui.soplarLaVela();
        System.out.println("\nA reventar los cohetes");
        reventarFuegosArtificiales();
        System.out.println("\nA comer la torta");
        distribuirTorta();
    }
}