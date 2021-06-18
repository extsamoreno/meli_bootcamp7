package com.example.demo.repositories;

import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.District;
import com.example.demo.model.Environment;
import com.example.demo.model.Property;
import com.example.demo.dtos.*;
import com.example.demo.services.mappers.MapperProperty;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PropertyRepositoryImple implements PropertyRepository {

    private ArrayList<Property> properties = new ArrayList<>();
    private ArrayList<Environment> environments = new ArrayList<>();
    private int id=1;
    Environment env1 = new Environment("Enviroment1",5d,10d);
    Environment env2 = new Environment("Enviroment2",6d,7d);
    Environment env3 = new Environment("Enviroment3",7d,8d);
    District district = new District(1,"District1",500d);
    Property prop1 = new Property(1,"Prop1",district,null);

    @Override
    public void loadData(){
        environments.add(env1);
        environments.add(env2);
        environments.add(env3);
        prop1.setEnvironments(environments);
        properties.add(prop1);

    }

    @Override
    public PropertyM2ResponseDTO getSquareMeter(int propId) throws PropertyDontFoundException {

        PropertyM2ResponseDTO propertyM2ResponseDTO;
        Property property = findPropertyById(propId);

        propertyM2ResponseDTO = MapperProperty.toPropertyM2ResponseDTO(property);

        return propertyM2ResponseDTO;
    }

    @Override
    public PropertyPriceResponseDTO getPrice(int propId) throws PropertyDontFoundException {
        PropertyPriceResponseDTO propertyPriceResponseDTO;
        Property property = findPropertyById(propId);

        propertyPriceResponseDTO = MapperProperty.toPropertyPriceResponseDTO(property);

        return propertyPriceResponseDTO;
    }

    @Override
    public BiggestPropResponseDTO getBiggestEnvProp(int propId) throws PropertyDontFoundException {
        BiggestPropResponseDTO biggestPropResponseDTO;
        Property property = findPropertyById(propId);

        biggestPropResponseDTO = MapperProperty.toBiggestPropResponseDTO(property);

        return biggestPropResponseDTO;
    }

    @Override
    public PropertyM2EnvsResponseDTO getMeterSquareEnvs(int propId) throws PropertyDontFoundException {
        PropertyM2EnvsResponseDTO propertyM2EnvsResponseDTO;
        Property property = findPropertyById(propId);

        propertyM2EnvsResponseDTO = MapperProperty.toPropertyM2EnvsDTO(property);

        return propertyM2EnvsResponseDTO;
    }

    @Override
    public PropertyRequestDTO addProperty(PropertyRequestDTO propertyRequestDTO) {


        Property property = MapperProperty.toProperty(propertyRequestDTO);
        property.setProp_id(id++);


        properties.add(property);

        return propertyRequestDTO;
    }

    @Override
    public Property findPropertyById(int propId) throws PropertyDontFoundException {
        Property property = null;

        for(Property prop:properties){
            if( prop.getProp_id() == propId){
                property = prop;
            }
        }

        if(property == null){
            throw new PropertyDontFoundException(propId);
        }
        return property;
    }

}
