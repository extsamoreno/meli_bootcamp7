package Ejercicio3;

import java.util.ArrayList;

public class PackFuegoMixto implements IFuegoArtificial{
    private ArrayList<IFuegoArtificial> listaFuegoMixto = new ArrayList<>();


    public PackFuegoMixto() {
    }

    public PackFuegoMixto(ArrayList<IFuegoArtificial> listaFuegoMixto) {
        this.listaFuegoMixto = listaFuegoMixto;
    }

    public void add(IFuegoArtificial fuego){
        this.listaFuegoMixto.add(fuego);
    }

    @Override
    public void explotar() {
        for (IFuegoArtificial fuego: listaFuegoMixto) {
            fuego.explotar();
        }
    }
}
