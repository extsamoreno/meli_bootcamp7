package Ejercicio3;

import java.util.ArrayList;

public class Evento {

    private String anfitrion;
    private boolean vela;
    private ArrayList<FuegoArtificial> listaFuegosArtificiales;
    private ArrayList<Invitados> listaInvitados;

    public Evento() {
        anfitrion = "La Chiqui";
        listaInvitados = new ArrayList<>();
        listaFuegosArtificiales = new ArrayList<>();
        vela = true;
    }

    public void apagarVela() throws InterruptedException {

        System.out.println("La " + anfitrion  + " soplo la vela");
        vela = false;
        accionarFuegosArtificiales();
        repartirTorta();
    }

    private void accionarFuegosArtificiales() {

        for (FuegoArtificial f : listaFuegosArtificiales) {
            f.accionar();
        }
    }

    private void repartirTorta() throws InterruptedException {

        for (Invitados i : listaInvitados) {
            System.out.println("Repartiendo torta a " + i.getNombre());
        }

        for (Invitados i : listaInvitados) {

            Thread.sleep(2000);
            i.gritar();
        }
    }

    public String getAnfitrion() {
        return anfitrion;
    }

    public void setAnfitrion(String anfitrion) {
        this.anfitrion = anfitrion;
    }

    public boolean isVela() {
        return vela;
    }

    public void setVela(boolean vela) {
        this.vela = vela;
    }

    public ArrayList<FuegoArtificial> getListaFuegosArtificiales() {
        return listaFuegosArtificiales;
    }

    public void setListaFuegosArtificiales(ArrayList<FuegoArtificial> listaFuegosArtificiales) {
        this.listaFuegosArtificiales = listaFuegosArtificiales;
    }

    public ArrayList<Invitados> getListaInvitados() {
        return listaInvitados;
    }

    public void setListaInvitados(ArrayList<Invitados> listaInvitados) {
        this.listaInvitados = listaInvitados;
    }

    public void addInvitado(Invitados inv){
        listaInvitados.add(inv);
    }
}
