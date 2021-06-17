package com.meli.desafio2.repository;

import com.meli.desafio2.dto.DistrictDTO;
import com.meli.desafio2.dto.PropertyDTO;
import com.meli.desafio2.dto.PropertyFullDTO;
import com.meli.desafio2.exception.PropertyNotFoundException;
import com.meli.desafio2.mapper.PropertyMapper;
import org.springframework.stereotype.Repository;



@Repository
public class PropertyRepository implements IPropertyRepository{

    @Override
    public PropertyDTO getById(int id) throws PropertyNotFoundException {
        PropertyDTO property = Tables.getPropertyByid(id);
        if(property!=null){
            return property;
        }else{
            throw new PropertyNotFoundException();
        }
    }

    @Override
    public PropertyFullDTO getFullById(int id) throws PropertyNotFoundException {
        PropertyDTO property = Tables.getPropertyByid(id);
        if(property!=null){
            DistrictDTO district = Tables.getDistrictByid(property.getDistrict_id());
            return PropertyMapper.DTOToResponseDTO(property,district);
        }else{
            throw new PropertyNotFoundException();
        }
    }

    @Override
    public DistrictDTO getDistrictByName(String districtName) {
        return Tables.getDistrictByName(districtName);
    }

    @Override
    public int newDistrict(DistrictDTO district) {
        return Tables.addDistrict(district);
    }

    @Override
    public int newProperty(PropertyDTO property) {
        return Tables.addProperty(property);
    }
}
