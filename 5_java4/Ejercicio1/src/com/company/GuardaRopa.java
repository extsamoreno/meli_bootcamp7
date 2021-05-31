package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import Prenda;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> almacen;
    private Integer contador;

    public GuardaRopa() {
        this.almacen = new HashMap<>();
        this.contador = 0;
    }

    public HashMap<Integer, List<Prenda>> getAlmacen() {
        return almacen;
    }

    public void setAlmacen(HashMap<Integer, List<Prenda>> almacen) {
        this.almacen = almacen;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador++;
        almacen.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer,List<Prenda>> entry: almacen.entrySet()) {
            Integer key = entry.getKey();
            List<Prenda> value = entry.getValue();
            System.out.println("Identificador="+key);
            for (int i = 0; i < value.size(); i++) {
                String marca=value.get(i).getMarca();
                String modelo=value.get(i).getModelo();
                System.out.println("Prenda"+(i+1)+": Marca="+ marca +", Modelo="+ modelo);
            }
            System.out.println(" ");
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return almacen.get(numero);
    }
}
