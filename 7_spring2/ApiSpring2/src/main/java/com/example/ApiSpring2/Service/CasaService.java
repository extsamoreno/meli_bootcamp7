package com.example.ApiSpring2.Service;

import com.example.ApiSpring2.Repositories.CasaRepository;
import com.example.ApiSpring2.dtos.CasaDTO;
import com.example.ApiSpring2.entities.Casa;
import com.example.ApiSpring2.entities.Habitacion;
import com.example.ApiSpring2.entities.HabitacionMetroCuadrado;

import java.util.ArrayList;

public class CasaService {
    public void cargarBase(){
        Habitacion[] habitaciones = {new Habitacion("cocina",123,2),new Habitacion("comedor",1,1)};
        Habitacion[] habitaciones2 = {new Habitacion("bano",1,1),new Habitacion("cuarto1",1,1),new Habitacion("cuarto2",1,1)};
        CasaRepository.agregarCasa("nom1","dir1", habitaciones);
        CasaRepository.agregarCasa("nom13","dir12", habitaciones2);
    }
    public CasaDTO getCasa(Integer id){
        Casa casa = CasaRepository.getCasas().get(id);
        return new CasaDTO(casa.getNombre(),casa.getDireccion(),casa.getHabitaciones());
    }
    public Integer getMetrosTotales(Habitacion[] habitaciones){
        Integer total = 0;
        for(Habitacion habitacion : habitaciones){
            total += habitacion.getAncho() * habitacion.getLargo();
        }
        return total;
    }
    public Integer getPrecio(Habitacion[] habitaciones){
        Integer total = 0;
        for(Habitacion habitacion : habitaciones){
            total += (habitacion.getAncho() * habitacion.getLargo())*800;
        }
        return total;
    }
    public Habitacion getMaxHabitacion(Habitacion[] habitaciones){
        Habitacion habitacionMasGrande = habitaciones[0];
        for(Habitacion habitacion : habitaciones){
            if (habitacionMasGrande.devolverMetrosTotales() < habitacion.devolverMetrosTotales()){
                habitacionMasGrande = habitacion;
            }
        }
        return habitacionMasGrande;
    }
    public ArrayList<HabitacionMetroCuadrado> getHabitacionMetroCuadrado(Habitacion[] habitaciones){
        ArrayList<HabitacionMetroCuadrado> habitacionesMetroCuad = new ArrayList<>();
        for(Habitacion habitacion : habitaciones){
            habitacionesMetroCuad.add(new HabitacionMetroCuadrado(habitacion.getNombre(),habitacion.devolverMetrosTotales()));
        }
        return habitacionesMetroCuad;
    }

}
