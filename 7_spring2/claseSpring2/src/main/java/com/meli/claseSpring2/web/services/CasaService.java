package com.meli.claseSpring2.web.services;

import com.meli.claseSpring2.web.dto.CasaDTO;
import com.meli.claseSpring2.web.dto.HabitacionDTO;
import com.meli.claseSpring2.web.response.AreasResponse;


import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

public class CasaService {
    static List<CasaDTO> listacasa = new ArrayList<>();
    public static void guardarCasa(CasaDTO casa){
        listacasa.add(casa);
    }

    public static CasaDTO obtenerCasa(String pnombre){
        for(CasaDTO casa:listacasa){
            if(casa.getNombre().equals(pnombre)){
                return casa;
            }
        }
        return(new CasaDTO());
    }
    public static double calculoArea(String nombre){
        CasaDTO casa = obtenerCasa(nombre);
        double area = 0;
        for(HabitacionDTO habitacion:casa.getListaHabitaciones()){
            area = area+(habitacion.getAncho()* habitacion.getLargo());
        }
        return area;
    }

    public static CasaDTO obtenerHabitacionGrande(){
        double mayor = 0;
        CasaDTO casamayor = new CasaDTO();
        HabitacionDTO habitacionmayor = new HabitacionDTO();
        for(CasaDTO casa:listacasa){
            for(HabitacionDTO habitacion:casa.getListaHabitaciones()){
                double area = habitacion.getAncho()* habitacion.getLargo();
                if (area>mayor){
                    mayor = area;
                    habitacionmayor = habitacion;
                    casamayor = casa;
                }
            }
        }
        return(casamayor);
    }
    public static List<AreasResponse> obtenerHabitaciones(String pnombre){
        CasaDTO casa = obtenerCasa(pnombre);
        List<AreasResponse> listaAreas = new ArrayList<>();

        for(HabitacionDTO habitacion:casa.getListaHabitaciones()){
            listaAreas.add(new AreasResponse(habitacion.getNombre(),(habitacion.getAncho()* habitacion.getLargo())));
        }
        return listaAreas;
    }


}
