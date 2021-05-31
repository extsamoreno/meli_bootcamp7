package com.company.saveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador;
    HashMap<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        contador = 0;
        prendas = new HashMap<Integer, List<Prenda>>();
    }

    //TODO: Check guardaropa que no se esten usando
    public Integer guardarPrendas(List<Prenda> lstPrendas) {
        int guardaRopa = contador;

        prendas.put(guardaRopa, lstPrendas);
        contador++;

        return guardaRopa;
    }

    public void mostrarPrendas() {
        for(Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            Integer key = entry.getKey();
            List<Prenda> value = entry.getValue();

            System.out.println("##############################");
            System.out.println("Guarda ropa nro " + key + ": ");
            printArray(value);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        if (!prendas.containsKey(numero)) return null;

        List<Prenda> prendasADevolver = prendas.get(numero);

        prendas.remove(numero);

        return prendasADevolver;
    }

    //Support function
    public static void printArray(List<Prenda> arr)
    {
        int n = arr.size();
        for (int i=0; i<n; ++i){
            System.out.print(arr.get(i).toString() + " - ");
        }
        System.out.println();
    }
}