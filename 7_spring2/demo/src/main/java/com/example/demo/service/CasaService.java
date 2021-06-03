package com.example.demo.service;

import com.example.demo.demo.Casa;
import com.example.demo.demo.CasaDTO;
import com.example.demo.demo.Habitacion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CasaService {
    ArrayList<Casa> listaCasas = new ArrayList<>();

    //Se pide, retornar un objeto que diga la cantidad totales de metros cuadrados de la casa.
    public double metrosCuadrados(Casa casa){
        ArrayList<Habitacion> listaHabitacion = new ArrayList<>();
        listaHabitacion = casa.getListaHabitaciones();
        double metrosTotales=0;

        for(int i=0 ;  i<listaHabitacion.size() ; i++){
            metrosTotales += listaHabitacion.get(i).getAncho()*listaHabitacion.get(i).getLargo();
        }
        return metrosTotales;
    }

    public Casa guardarCasa(Casa casa){
        listaCasas.add(casa);
        return casa;
    }


    public CasaDTO devolverCasa(String nombre){
        CasaDTO responseDTOcasa = new CasaDTO();
        for(int i=0 ; i<listaCasas.size() ; i++){
            if(listaCasas.get(i).getNombre().equals(nombre)){
                responseDTOcasa.setCasa(listaCasas.get(i));
                responseDTOcasa.setMetrosTotales(metrosCuadrados(listaCasas.get(i)));
            }
        }
        return responseDTOcasa;
    }


    //Indicar el valor de la casa tomando en cuenta que se toma como referencia USD 800 el metro cuadrado.
    public CasaDTO getPrecio(String nombre){
        CasaDTO responseDTOcasa;

        responseDTOcasa = devolverCasa(nombre);
        responseDTOcasa.setPrecio(responseDTOcasa.getMetrosTotales()*800);

        return responseDTOcasa;
    }


    //Retornar el objeto con la habitación más grande.
    public Casa obtenerCasaHabitacionGrande(){
        double mayor = 0;
        Casa casamayor = new Casa();
        for(Casa casa:listaCasas){
            for(Habitacion habitacion:casa.getListaHabitaciones()){
                double area = habitacion.getAncho()* habitacion.getLargo();
                if (area>mayor){
                    mayor = area;
                    casamayor = casa;
                }
            }
        }
        return(casamayor);
    }

    public double calcularMetros(Habitacion habitacion){
        return habitacion.getAncho()*habitacion.getLargo();
    }

    public HashMap<Double, Habitacion> obtenerListaHabitacionesMetros(Casa casa) {
        HashMap<Double, Habitacion> hashMapHab = new HashMap<>();

        for(Habitacion h : casa.getListaHabitaciones()){
            hashMapHab.put(calcularMetros(h), h);
        }

        return hashMapHab;

    }


}
