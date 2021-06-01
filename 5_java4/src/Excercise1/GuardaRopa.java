package Excercise1;

import com.sun.source.tree.BreakTree;

import java.util.*;

public class GuardaRopa {
    int contador;
    Map<Integer, List<Prenda>>  dicc = new HashMap<Integer, List<Prenda>>();

    public GuardaRopa() {

    }

    //recibe una lista de prendas y devuelve el numero identificador en el guardatopa
    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador= dicc.size();
        contador++;
        dicc.put(contador,listaDePrenda);
        contador= dicc.size();
        return contador;
    }
    //Imprime todas las prendas en el guardaropa con los numeros que le corresponden
    public void mostrarPrendas(){
        for (Map.Entry<Integer,List<Prenda>> entry: dicc.entrySet()) {
            System.out.println("Llave: "+entry.getKey());
            for (Prenda prenda: entry.getValue()) {
                System.out.println("    Marca: "+prenda.getMarca()+" Modelo: "+ prenda.getModelo());
            }
        }
    }

    //devuelve la lista de prendas que estan guardadas bajo ese numero
    public List<Prenda> devolverPrendas(Integer numero){
        var valor= dicc.get(numero);
        return valor;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Map<Integer, List<Prenda>> getDicc() {
        return dicc;
    }

    public void setDicc(Map<Integer, List<Prenda>> dicc) {
        this.dicc = dicc;
    }
}
