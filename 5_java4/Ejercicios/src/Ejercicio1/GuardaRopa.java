package Ejercicio1;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private static int count = 0;
    private static HashMap<Integer, List<Prenda>> dictionary;

    public GuardaRopa() {
        this.dictionary = new HashMap<Integer, List<Prenda>>();
    }

    // Metodos
    public Integer guardarPrendas(List<Prenda> listaDePrenda) {

        count++;
        dictionary.put(count, listaDePrenda);
        return count;
    }

    public void mostrarPrendas() {

        for (List<Prenda> prenda : dictionary.values()) {
            System.out.println(prenda.toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return GuardaRopa.dictionary.get(numero);
    }


    // Getters y Setters
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        GuardaRopa.count = count;
    }

    public HashMap<Integer, List<Prenda>> getDictionary() {
        return dictionary;
    }

    public void setDictionary(HashMap<Integer, List<Prenda>> dictionary) {
        this.dictionary = dictionary;
    }
}
