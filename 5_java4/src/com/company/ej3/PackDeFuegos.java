package com.company.ej3;

import java.util.ArrayList;
import java.util.List;

public class PackDeFuegos implements Component {

    private List<Component> hijos = new ArrayList<>();

    public PackDeFuegos() {
    }

    public void add(Component c) {
        hijos.add(c);
    }

    public void remove(Component c) {
        hijos.remove(c);
    }

    @Override
    public void explotar() {
        for (Component c : hijos) {
            c.explotar();
        }
    }

}
