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

    private Integer guardarPrendas(Integer ubicacion, List<Prenda> lstPrendas) {
        int guardaRopa = ubicacion;

        prendas.put(ubicacion, lstPrendas);
        contador++;

        return guardaRopa;
    }

    public Integer guardarPrendas(List<Prenda> lstPrendas) {
        if (contador > 0) {
            for (int i = 0; i < lstPrendas.size(); i++)
                if (!prendas.containsKey(i)) {
                    prendas.put(i, lstPrendas);
                    return i;
                }
        }
        int guardaRopa = contador;

        prendas.put(guardaRopa, lstPrendas);
        contador++;

        return guardaRopa;
    }

    public void mostrarPrendas() {
        System.out.println("######### Estado casilleros ###########");

        for(Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            Integer key = entry.getKey();
            List<Prenda> value = entry.getValue();

            System.out.println("Guarda ropa nro " + key + ": ");
            printArray(value);
        }
        System.out.println("#######################################");
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
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}