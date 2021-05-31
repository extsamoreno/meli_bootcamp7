package ejercicios.savetheropa;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private Integer contador=1;
    private HashMap<Integer, List<Prenda>> diccionario = new HashMap();

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(contador,listaDePrenda);
        contador ++;
        return contador-1;
    }

    public void mostrarPrendas(){
        for (int i = 1; i <= diccionario.size() ; i++) {
            List<Prenda> aux = diccionario.get(i);
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Numero: " + i);
            for (int j = 0; j < aux.size(); j++) {
                System.out.println("Prenda nº"+ j+ " Marca: "+aux.get(j).getMarca() + " Modelo: "+ aux.get(j).getModelo());
            }
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }
}



