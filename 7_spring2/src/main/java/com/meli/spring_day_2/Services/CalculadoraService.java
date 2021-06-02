package com.meli.spring_day_2.Services;

import com.meli.spring_day_2.Clases.Casa;
import com.meli.spring_day_2.Clases.Habitacion;
import com.meli.spring_day_2.Dto.CasaDto;

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

}
