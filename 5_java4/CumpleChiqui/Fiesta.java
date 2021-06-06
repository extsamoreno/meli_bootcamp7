package CumpleChiqui;

import java.util.ArrayList;

public class Fiesta {
    ArrayList<Invitado> invitados;
    ArrayList<FuegoArtificial> fuegosArtificiales;

    public Fiesta(ArrayList<Invitado> invitados, ArrayList<FuegoArtificial> fuegosArtificiales) {
        this.invitados = invitados;
        this.fuegosArtificiales = fuegosArtificiales;
    }

    public Fiesta() {
        this.invitados = new ArrayList<>();
        this.fuegosArtificiales = new ArrayList<>();
    }

    public void apagarVela() {
        System.out.println("La Chiqui apago las velas");
        for (FuegoArtificial fuegos : this.fuegosArtificiales) {
            fuegos.explotar();
        }
    }

    public void cortarTorta() {
        for (Invitado inv : this.invitados) {
            inv.alabar();
        }
    }


}
