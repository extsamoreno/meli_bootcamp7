package SaveTheRopaSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class GuardaRopa {

    private HashMap <Integer, List<Prenda>> diccionario;
    private int identificador;

    public GuardaRopa() {
        this.identificador = 0;
        this.diccionario = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        identificador++;
        diccionario.put(identificador, listaDePrenda);
        return identificador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println("Identificador: " + entry.getKey());
            IntStream.range(0, entry.getValue().size()).forEach(i -> {
                System.out.println(entry.getValue().get(i).toString());
            });
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return (diccionario.get(numero));
    }
}
