package com.ej1;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    HashMap<Integer, List<Prenda>> dic = new HashMap<Integer, List<Prenda>>();
    int contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador++;
        dic.put(contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        if (dic.size() == 0){
            System.out.println("Guardaropas Vacio");
            return;
        }
        dic.forEach((key,value)-> {
            System.out.print("Numero: " + key);
            printList(value);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return dic.remove(numero);
    }

    private void printList(List<Prenda> lp){
        System.out.print(" Prendas: ");
        for (Prenda p: lp
             ) {
            System.out.print(p + ", ");
        }
        System.out.println("");
    }
}
