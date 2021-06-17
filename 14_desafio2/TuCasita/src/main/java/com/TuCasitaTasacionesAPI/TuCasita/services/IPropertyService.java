package com.TuCasitaTasacionesAPI.TuCasita.services;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.*;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.Property;

public interface IPropertyService {
    int create(PropertyDTO propertyDTO) throws PropertyAlreadyExistsException, DistrictNotFoundException;
    //PropertyDTO getById(int idProperty) throws PropertyNotFoundException;
    TotalM2DTO calculateM2(int idProperty) throws PropertyNotFoundException;
    PricePropertyDTO calculatePrice(int idProperty) throws PropertyNotFoundException, DistrictNotFoundException;
    EnvironmentBiggestDTO environmentBiggest(int idProperty) throws PropertyNotFoundException;
    M2perEnvironmentsDTO m2perEnvironments(int idProperty) throws PropertyNotFoundException;
}
