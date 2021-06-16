package com.TuCasitaTasacionesAPI.TuCasita.exceptions.property;

import com.TuCasitaTasacionesAPI.TuCasita.exceptions.ObjectException;
import org.springframework.http.HttpStatus;

public class PropertyAlreadyExistsException extends ObjectException {
    public PropertyAlreadyExistsException(String name, int idDistrict) {
        super("Ya existe registrada una propiedad con la información: " + name + "en el barrio " + idDistrict,
                HttpStatus.CONFLICT);
    }
}
