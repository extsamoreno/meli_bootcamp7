package com.meli.tucasita.service;

import com.meli.tucasita.exception.DistrictNotFoundException;
import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.service.dto.*;
import org.springframework.http.HttpStatus;

public interface IPropertyService {
    public PropertyWithM2DTO getTotalM2(String name) throws PropertyNotFoundException;
    public HttpStatus addNewProperty(PropertyDTORequest property) throws DistrictNotFoundException;
    public PropertyWithPriceDTO getPrice(String name) throws PropertyNotFoundException;
    public PropertyWithEnvAndMetersDTO getMetersPerEnvironment(String name) throws PropertyNotFoundException;
    public PropertyWithBiggerEnvDTO getBiggerEnvironment(String name) throws PropertyNotFoundException;
}
