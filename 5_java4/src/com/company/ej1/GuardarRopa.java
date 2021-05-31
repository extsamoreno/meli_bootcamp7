package com.company.ej1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {

    private HashMap<Integer, List<Prenda>> map;
    private int counter;

    public GuardarRopa() {
        this.map = new HashMap<>();
        this.counter = 0;
    }

    // una persona puede guardar varias prendas a su nombre.
    public Integer guardarPrendas(List<Prenda> listaDePrenda) {

        this.map.put(this.counter, listaDePrenda);
        this.counter++;
        return this.counter-1;

    }

    public void mostrarPrendas() {

        for (Map.Entry<Integer,List<Prenda>> entry : map.entrySet()) {

            System.out.println("Nro ticket = " + entry.getKey() + " | Tiene prendas :");

            for (Prenda p : entry.getValue()) {
                System.out.println(p.toString());
            }
        }

    }

    public List<Prenda> devolverPrendas(Integer numero) {

        List<Prenda> list = this.map.get(numero);

        this.map.remove(numero);

        return list;
    }

}
