package com.TuCasitaTasacionesAPI.TuCasita.exceptions.district;

import com.TuCasitaTasacionesAPI.TuCasita.exceptions.ObjectException;
import org.springframework.http.HttpStatus;

public class DistrictAlreadyExistsException extends ObjectException {
    public DistrictAlreadyExistsException(String name) {
        super("El barrio " + name + " ya existe.", HttpStatus.CONFLICT);
    }
}
