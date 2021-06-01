package Ejercicio1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    HashMap<Integer, ArrayList<Prenda>> diccionario;
    private int contador;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        /*for (int key: diccionario.keySet()) {
            if (diccionario.get(key)==listaDePrenda) {
                return key;
            }
        }
        return -1; // Indica que no se encontró en ninguna posición del diccionario.
         */
        this.diccionario.put(this.contador,(ArrayList) listaDePrenda);
        this.contador++;
        return this.contador -1;
    }
    public void mostrarPrendas(){
        for (int key: this.diccionario.keySet()) {
            System.out.println(key);
            ArrayList<Prenda> listaDePrendas = this.diccionario.get(key);
            for (int i=0;i<listaDePrendas.size();i++) {
                System.out.println(listaDePrendas.get(i).getModelo()+" "+listaDePrendas.get(i).getMarca());
            }
        }
    }
    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> listaDePrendas;
        listaDePrendas = this.diccionario.get(numero);
        return listaDePrendas;
    }

}
