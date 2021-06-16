package com.TuCasitaTasacionesAPI.TuCasita.repositories;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.PropertyDTO;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.Property;

public interface IPropertyRepository {
    int create(Property property) throws PropertyAlreadyExistsException;
    Property getById(int id) throws PropertyNotFoundException;
}
