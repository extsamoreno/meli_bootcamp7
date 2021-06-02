package com.example.ApiSpring2.Repositories;

import com.example.ApiSpring2.entities.Casa;
import com.example.ApiSpring2.entities.Habitacion;

import java.util.ArrayList;

public class CasaRepository {
    private static ArrayList<Casa> casas = new ArrayList<Casa>();
    private static Integer contador = 0;
    public static ArrayList<Casa> getCasas(){
        return casas;
    }
    public static void agregarCasa(String nombre, String direccion, Habitacion[] habitacion){
        casas.add( new Casa(contador, nombre,direccion, habitacion));
        contador++;
    }
}
