package com.TuCasitaTasacionesAPI.TuCasita.exceptions.property;

import com.TuCasitaTasacionesAPI.TuCasita.exceptions.ObjectException;
import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends ObjectException {
    public PropertyNotFoundException(int id) {
        super("La propiedad " + id + "no fue encontrada.", HttpStatus.NOT_FOUND);
    }
}
