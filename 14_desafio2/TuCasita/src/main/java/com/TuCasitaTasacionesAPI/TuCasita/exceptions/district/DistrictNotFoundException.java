package com.TuCasitaTasacionesAPI.TuCasita.exceptions.district;

import com.TuCasitaTasacionesAPI.TuCasita.exceptions.ObjectException;
import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends ObjectException {
    public DistrictNotFoundException(int id) {
        super("Barrio " + id + " no encontrado", HttpStatus.NOT_FOUND);
    }
}
