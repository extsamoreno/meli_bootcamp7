import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private static Integer contador=0;
    private static HashMap<Integer, List<Prenda>> dict= new HashMap<>();

    public static Integer guardarPrendas(List<Prenda> listaDePrenda){
        dict.put(contador,listaDePrenda);
        contador++;
        return contador-1;
    }

    public static void mostrarPrendas(){
        dict.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
    }

    public static List<Prenda> devolverPrendas(Integer numero){
        return dict.get(numero);
    }


}
