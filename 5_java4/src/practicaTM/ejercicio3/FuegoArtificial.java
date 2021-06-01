package practicaTM.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class FuegoArtificial {

    List<FuegoArtificial> cohetes = new ArrayList<>();
    private String ruido;

    public FuegoArtificial() {
    }

    public FuegoArtificial(String ruido) {
        this.ruido = ruido;
    }

    public FuegoArtificial(List<FuegoArtificial> cohetes, String ruido) {
        this.cohetes = cohetes;
        this.ruido = ruido;
    }

    public List<FuegoArtificial> getCohetes() {
        return cohetes;
    }

    public void setCohetes(List<FuegoArtificial> cohetes) {
        this.cohetes = cohetes;
    }

    public String getRuido() {
        return ruido;
    }

    public void setRuido(String ruido) {
        this.ruido = ruido;
    }


    public void explotar() {
        System.out.println(ruido);
        cohetes.forEach(elem -> elem.explotar());
    }

    public void agregarCohete(FuegoArtificial cohete) {
        cohetes.add(cohete);
    }


}
