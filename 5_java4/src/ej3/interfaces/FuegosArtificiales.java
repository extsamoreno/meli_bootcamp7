package ej3.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface FuegosArtificiales extends Pirotecnia {
    String getExplosion();

    default void explotar(){
        System.out.println(this.getClass().getSimpleName() + " hace: " + this.getExplosion());
    }

    @Override
    default List<Pirotecnia> listarFuegosArtificiales() {
        var listaLocal = new ArrayList<Pirotecnia>();
        listaLocal.add(this);
        return listaLocal;
    }

}
