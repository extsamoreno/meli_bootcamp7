package com.meli.spring_day_2.PracticaMañana.Services;

import com.meli.spring_day_2.PracticaMañana.Clases.Casa;
import com.meli.spring_day_2.PracticaMañana.Clases.Habitacion;
import com.meli.spring_day_2.PracticaMañana.Dto.CasaDto;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalculadoraService {
    private final float PRECIO_MTS2 = 800;

    public CasaDto calcularMts(Casa casa){
        CasaDto result = new CasaDto();
        float totalMts2 = 0;
        Habitacion masGrande = null;
        float mtsMax = 0;


        for(Habitacion habitacion : casa.getHabitacionList()){

            if(masGrande == null){
                masGrande = habitacion;
                mtsMax = habitacion.getAncho() * habitacion.getLargo();
                totalMts2 += mtsMax;
            }else{
                if(mtsMax < habitacion.getAncho() * habitacion.getLargo()){
                    masGrande = habitacion;
                    mtsMax = habitacion.getAncho() * habitacion.getLargo();
                }
                totalMts2 += habitacion.getAncho() * habitacion.getLargo();
            }

            result.getMtrsHabitaciones().put(habitacion, habitacion.getAncho() * habitacion.getLargo());
        }

        result.setNombre(casa.getNombre());
        result.setMetrosCuadrados(totalMts2);
        result.setPreciocasa(totalMts2 * PRECIO_MTS2);
        result.setHabitacionGrande(masGrande);

        return result;
    }

    public int calcularEdad(int dia, int mes, int año){
        Calendar fechaNacimiento = new GregorianCalendar(año, mes, dia);
        Calendar ahora = Calendar.getInstance();

        long edadEnDias = (ahora.getTimeInMillis() - fechaNacimiento.getTimeInMillis()) / 1000 / 60 / 60 / 24;
        int años = Double.valueOf(edadEnDias / 365.25d).intValue();

        return años;
    }
}
