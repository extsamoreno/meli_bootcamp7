package primerejercicio.metrocuadrado.web.service;

import org.springframework.stereotype.Service;
import primerejercicio.metrocuadrado.web.DTO.Casa;
import primerejercicio.metrocuadrado.web.DTO.Habitacion;
import primerejercicio.metrocuadrado.web.DTO.ResponseDTOcasa;

import java.util.*;

@Service
public class ServiceCasa {
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


    public ResponseDTOcasa devolverCasa(String nombre){
        ResponseDTOcasa responseDTOcasa = new ResponseDTOcasa();
        for(int i=0 ; i<listaCasas.size() ; i++){
            if(listaCasas.get(i).getNombre().equals(nombre)){
                responseDTOcasa.setCasa(listaCasas.get(i));
                responseDTOcasa.setMetrosTotales(metrosCuadrados(listaCasas.get(i)));
            }
        }
        return responseDTOcasa;
    }


    //Indicar el valor de la casa tomando en cuenta que se toma como referencia USD 800 el metro cuadrado.
    public ResponseDTOcasa getPrecio(String nombre){
        ResponseDTOcasa responseDTOcasa;

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

/*    public Casa getCasaHabitacionMasGrande() {
        Casa casa = listaCasas.stream().filter(c-> c.getListaHabitaciones().contains(habitacionMasGrande())).findFirst().get();
        return casa;
    }

    private Habitacion habitacionMasGrande() {
        HashMap<Double, Habitacion> hashMapHab = new HashMap<>();
        Habitacion hab = new Habitacion();

        for(Casa c : listaCasas){

            for(Habitacion h : c.getListaHabitaciones()){
                hashMapHab.put(calcularMetros(h),h);
            }
        }
        hashMapHab.
        return
    }*/


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
