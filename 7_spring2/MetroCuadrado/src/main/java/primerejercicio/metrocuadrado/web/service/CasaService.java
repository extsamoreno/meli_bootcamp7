package primerejercicio.metrocuadrado.web.service;

import primerejercicio.metrocuadrado.Casa;
import primerejercicio.metrocuadrado.Habitacion;
import primerejercicio.metrocuadrado.web.controller.MetrosCuadradosController;

import java.util.ArrayList;

public class CasaService {

    public double metrosCuadrados(Casa casa){
        ArrayList<Habitacion> listaHabitacion = new ArrayList<>();
        listaHabitacion = casa.getListaHabitaciones();
        double metrosTotales=0;

        for(int i=0 ;  i<listaHabitacion.size() ; i++){
            metrosTotales += listaHabitacion.get(i).getAncho()*listaHabitacion.get(i).getLargo();
        }
        return metrosTotales;
    }



}
