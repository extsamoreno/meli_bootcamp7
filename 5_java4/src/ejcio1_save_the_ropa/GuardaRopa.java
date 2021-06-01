package ejcio1_save_the_ropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private static Map<Integer, List<Prenda>> diccionario = new HashMap<>();
    private static int contador = 0;

    // Métodos
    public static Integer guardarPrendas(List<Prenda> listaDePrendas) {
        contador++;
        diccionario.put(contador, listaDePrendas);
        return contador;
    }

    public static void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println("Prendas asociadas al ticket " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<Prenda> devolverPrendas(Integer numero) throws Exception {
        if (diccionario.containsKey(numero))
            return diccionario.get(numero);
        throw new Exception("No existe un elemento con ese número");
    }

    // Getters & Setters
    public static Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public static void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        GuardaRopa.diccionario = diccionario;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        GuardaRopa.contador = contador;
    }
}
