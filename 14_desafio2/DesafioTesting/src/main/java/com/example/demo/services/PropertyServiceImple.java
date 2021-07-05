package com.example.demo.services;

import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.Environment;
import com.example.demo.model.Property;
import com.example.demo.repositories.DistrictRepository;
import com.example.demo.repositories.PropertyRepository;
import com.example.demo.dtos.*;
import com.example.demo.services.mappers.MapperEnviroment;
import com.example.demo.services.mappers.MapperProperty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PropertyServiceImple implements PropertyService{

    PropertyRepository propertyRepository;

    DistrictRepository districtRepository;

    MapperProperty mapperProperty;

    MapperEnviroment mapperEnviroment;

    @Override
    public PropertyM2ResponseDTO getMeterSquare(int propId) throws PropertyDontFoundException {

        Property property = propertyRepository.findPropertyById(propId);

        PropertyM2ResponseDTO propertyM2ResponseDTO= mapperProperty.toPropertyM2ResponseDTO(property);

        propertyM2ResponseDTO.setProp_square_meters(squareMeters(property));

        return propertyM2ResponseDTO;
    }

    @Override
    public PropertyPriceResponseDTO getPrice(int propId) throws PropertyDontFoundException {

        Property property = propertyRepository.findPropertyById(propId);

        PropertyPriceResponseDTO propertyPriceResponseDTO = mapperProperty.toPropertyPriceResponseDTO(property);

        propertyPriceResponseDTO.setProp_price(propertyPrice(property));

        return propertyPriceResponseDTO;
    }

    @Override
    public BiggestPropResponseDTO getBiggestEnvProp(int propId) throws PropertyDontFoundException {

        Property property = propertyRepository.findPropertyById(propId);

        BiggestPropResponseDTO biggestPropResponseDTO = mapperProperty.toBiggestPropResponseDTO(property);

        biggestPropResponseDTO.setBiggestEnvironment(MapperEnviroment.toBiggestEnvironmentDTO(biggestEnvironment(property.getEnvironments())));

        return biggestPropResponseDTO;
    }

    @Override
    public PropertyM2EnvsResponseDTO getMeterSquareEnvs(int propId) throws PropertyDontFoundException {
        Property property = propertyRepository.findPropertyById(propId);

        PropertyM2EnvsResponseDTO propertyM2EnvsResponseDTO = mapperProperty.toPropertyM2EnvsDTO(property);

        propertyM2EnvsResponseDTO.setEnviroments(enviromentsM2(property.getEnvironments()));

        return propertyM2EnvsResponseDTO;
    }

    @Override
    public PropertyRequestDTO addProperty(PropertyRequestDTO propertyRequestDTO) throws DistrictDontFoundException {
        districtRepository.findDistrictById(propertyRequestDTO.getDistrict().getDistrict_id());

        Property property = mapperProperty.toProperty(propertyRequestDTO);
        property = propertyRepository.addProperty(property);

        PropertyRequestDTO propertyResponseDTO = mapperProperty.toPropertyDTO(property);

        return propertyResponseDTO;
    }

    @Override
    public Property findPropertyById(int propId) throws PropertyDontFoundException {
        return propertyRepository.findPropertyById(propId);
    }

    public double squareMeters(Property property){
        double squareMeters = 0;

        for(Environment env: property.getEnvironments()){
            squareMeters+=env.getEnvironment_width()* env.getEnvironment_length();
        }

        return squareMeters;
    }

    public double propertyPrice(Property property){

        double price = property.getDistrict().getDistrict_price()*squareMeters(property);

        return price;
    }

    public Environment biggestEnvironment(List<Environment> environmentList){

        Environment biggestEnvironment = null;

        for(Environment environment:environmentList){
            if(biggestEnvironment==null){
                biggestEnvironment = environment;
            }else{
                double mayor = biggestEnvironment.getEnvironment_length()*biggestEnvironment.getEnvironment_width();
                double comparar = environment.getEnvironment_length()*environment.getEnvironment_width();
                if(comparar > mayor){
                    biggestEnvironment = environment;
                }
            }
        }

        return biggestEnvironment;
    }

    public List<EnvironmentM2DTO> enviromentsM2(List<Environment> environmentList){

        List<EnvironmentM2DTO> environmentM2DTOList = new ArrayList<>();

        for(Environment environment:environmentList){
                EnvironmentM2DTO environmentM2DTO = MapperEnviroment.toM2EnviromentDTO(environment);
                double squareMeters = 0;
                squareMeters = environment.getEnvironment_width()*environment.getEnvironment_length();

                environmentM2DTO.setSquare_meters(squareMeters);

                environmentM2DTOList.add(environmentM2DTO);
        }

        return environmentM2DTOList;
    }

}
