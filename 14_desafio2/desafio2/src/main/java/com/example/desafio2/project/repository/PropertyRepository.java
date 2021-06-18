package com.example.desafio2.project.repository;

import com.example.desafio2.project.exceptions.PropertyAlreadyExistsException;
import com.example.desafio2.project.exceptions.PropertyDistrictNameNotFoundException;
import com.example.desafio2.project.exceptions.PropertyNameNotFoundException;
import com.example.desafio2.project.models.District;
import com.example.desafio2.project.models.Property;
import com.example.desafio2.project.utils.Database;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@AllArgsConstructor
@Repository
public class PropertyRepository implements IPropertyRepository{
    private static List<Property> listProperties = Database.listProperties; //List of properties
    private static List<District> listDistricts = Database.listDistricts; //List of districts

    @Override
    public Property findPropertyByName(String propertyName) throws PropertyNameNotFoundException {
        try{
            return listProperties.stream().filter(x -> x.getProp_name().equals(propertyName)).findFirst().get();
        }
        catch (NoSuchElementException e){
            throw new PropertyNameNotFoundException(propertyName);
        }
    }

    @Override
    public District findDistrictByName(String districtName) throws PropertyDistrictNameNotFoundException {
        try{
            return listDistricts.stream().filter(x -> x.getDistrict_name().equals(districtName)).findFirst().get();
        }
        catch (NoSuchElementException e){
            throw new PropertyDistrictNameNotFoundException(districtName);
        }
    }

    @Override
    public void saveProperty(Property property) throws PropertyAlreadyExistsException, PropertyDistrictNameNotFoundException {
        if(listProperties.stream().anyMatch(x -> x.getProp_name().equals(property.getProp_name())))
            throw new PropertyAlreadyExistsException(property.getProp_name());

        if(!listDistricts.stream().anyMatch(x -> x.getDistrict_name().equals(property.getProp_district_name())))
            throw new PropertyDistrictNameNotFoundException(property.getProp_district_name());

        listProperties.add(property);
    }

}
