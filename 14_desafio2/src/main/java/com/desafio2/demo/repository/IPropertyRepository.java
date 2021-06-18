package com.desafio2.demo.repository;

import com.desafio2.demo.dtos.DistrictDTO;
import com.desafio2.demo.dtos.PropertyDTO;
import com.desafio2.demo.exception.DistrictAlreadyExistException;
import com.desafio2.demo.exception.DistrictNotFoundException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.District;
import com.desafio2.demo.model.Property;

public interface IPropertyRepository{
    Property saveProperty(Property property) throws PropertyAlreadyExistException;
    District saveDistrict(District district) throws DistrictAlreadyExistException;
    Property getPropertyById(int propertyId) throws PropertyNotFoundException;
    District getDistrictById(String district) throws DistrictNotFoundException;
}
