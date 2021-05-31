import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> diccionario;
    private Integer contador = 0;

    public GuardaRopa() {
        diccionario = new HashMap<>();
    }

    public Integer guardarPrenda(List<Prenda> listaPrenda){

        diccionario.put(contador,listaPrenda);
        return contador++;
    }

    public void mostrarPrenda (){
        diccionario.forEach((k,v) -> {System.out.println("Identificador " + k);
                                      v.forEach((l) -> System.out.println(l) );  });

    }

    public List<Prenda> devolverPrenda(Integer identificador){
        List<Prenda> listPrendaRemovida = diccionario.get(identificador);
        diccionario.remove(identificador);
        return listPrendaRemovida;

    }
}
