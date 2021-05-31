package com.ejercitacion.m.primero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> inventory;
    private int contador = 0;

    public GuardaRopa(Map<Integer, List<Prenda>> inventory, int contador) {
        this.inventory = inventory;
        this.contador = contador;
    }

    public GuardaRopa() {
        this.inventory = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas) {
        this.inventory.put(contador, (ArrayList<Prenda>) listaPrendas);
        return contador++;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : inventory.entrySet()) {
            System.out.println("Número de inventario:" + entry.getKey());
            for (Prenda prenda : entry.getValue()) {
               System.out.println(prenda.toString());
            }
        }
    }


    public List<Prenda> devolverPrendas(Integer numero) {
        return inventory.get(numero);
    }

    public Map<Integer, List<Prenda>> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Integer, List<Prenda>> inventory) {
        this.inventory = inventory;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
