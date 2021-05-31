package SaveTheRopaSA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> diccionario = new HashMap();
    private Integer contador;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public GuardaRopa(HashMap<Integer, List<Prenda>> diccionario, Integer contador) {
        this.diccionario = diccionario;
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.contador++;
        diccionario.put(this.contador, listaDePrenda);

        return this.contador;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer,List<Prenda>> item : diccionario.entrySet()){
            System.out.println("Ticker#" + item.getKey());
            System.out.print("Ropa: ");
            for(Prenda ropa : item.getValue()){
                System.out.print(ropa.toString() + " ");
            }
            System.out.println();
            System.out.println("---------------------------------");
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.remove(numero);
    }


    public HashMap<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
