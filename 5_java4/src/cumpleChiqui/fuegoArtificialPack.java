package cumpleChiqui;

import java.util.ArrayList;

public class fuegoArtificialPack extends fuegoArtificialIndividual implements fuegoArtificial {

    private ArrayList <fuegoArtificialIndividual> fuegos = new ArrayList<fuegoArtificialIndividual>();

    //este add puede recibir un fuego artificial o un pack
    public void add(fuegoArtificialIndividual fuego){
        if(fuego!=null)
            fuegos.add(fuego);
        else
            System.out.println("No fue posible agregar el fuego artificial a la lista");
    }


    public void add(ArrayList <fuegoArtificialIndividual> afuegos){
        if(afuegos!=null)
            for(fuegoArtificialIndividual f:afuegos)
                fuegos.add(f);
        else
            System.out.println("No fue posible agregar el fuego artificial a la lista");
    }

    @Override
    public void getSonidoAlExplotar() {

        for (fuegoArtificialIndividual fuego: fuegos){
            fuego.getSonidoAlExplotar();
        }
    }

    @Override
    public void setSonidoAlExplotar(String sonido) {

        for (fuegoArtificialIndividual fuego: fuegos){
            fuego.setSonidoAlExplotar(sonido);
        }
    }
}
