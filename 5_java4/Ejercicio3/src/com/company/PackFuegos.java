package com.company;

import java.util.ArrayList;

public class PackFuegos<T> implements Explosivo<T> {
    private ArrayList<T> pack;

    public PackFuegos(){
        this.pack = new ArrayList<>();
    }

    public void agregarFuegoAlPack(T fuego){
        pack.add(fuego);
    }

    @Override
    public void explotar() {
        for (T f : pack) {
            if( f instanceof Fuego ){
                ((Explosivo<Fuego>) f).explotar();
            }
            if( f instanceof PackFuegos ) {
                ((Explosivo<PackFuegos>) f).explotar();
            }
        }
    }
}
