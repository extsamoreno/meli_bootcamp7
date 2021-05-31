package parte1.clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> diccionario;
    private int cont;

    public GuardaRopa() {
        diccionario=new HashMap<Integer,List<Prenda>>();
        cont=0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        cont++;
        diccionario.put(cont,listaDePrenda);
        return cont;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer,List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println(entry.getKey()+" / "+entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.remove(numero);
    }
}