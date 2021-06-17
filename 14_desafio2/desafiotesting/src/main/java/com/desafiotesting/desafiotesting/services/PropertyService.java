package com.desafiotesting.desafiotesting.services;
import com.desafiotesting.desafiotesting.models.Enviroment;
import com.desafiotesting.desafiotesting.models.Property;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentDTO;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentWithSquareMetersDTO;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;
import com.desafiotesting.desafiotesting.models.District;
import com.desafiotesting.desafiotesting.repositories.IDistrictRepository;
import com.desafiotesting.desafiotesting.repositories.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    IDistrictRepository districtRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public double totalSquareMeters(int id) {
        Property property = propertyRepository.findById(id);
        double total = 0.0;
        for (Enviroment enviroment: property.getEnviroments()
             ) {
            total += getEnviromentTotalSquareMeters(enviroment);
        }
        return total;
    }

    @Override
    public double getPriceProperty(int id) {
        Property property = propertyRepository.findById(id);
        return totalSquareMeters(id) * property.getDistrict().getPrice();
    }

    @Override
    public EnviromentDTO getBiggerEnviroment(int id) {
        Property property = propertyRepository.findById(id);
        double major = 0;
        int index = 0;
        for (int i = 0; i < property.getEnviroments().size() ; i++) {
            if(major < getEnviromentTotalSquareMeters(property.getEnviroments().get(i))){
                major = getEnviromentTotalSquareMeters(property.getEnviroments().get(i));
                index = i;
            }
        }
        return mapper.map(
                property.getEnviroments().get(index),
                EnviromentDTO.class
        );
    }

    @Override
    public List<EnviromentWithSquareMetersDTO> getEnviromentsInfo(int id) {
        Property property = propertyRepository.findById(id);
        List<EnviromentWithSquareMetersDTO> list = new ArrayList<>();
        for (Enviroment enviroment : property.getEnviroments()
             ) {
            list.add(
                    new EnviromentWithSquareMetersDTO(
                            enviroment.getName(),
                            enviroment.getWidth(),
                            enviroment.getLength(),
                            getEnviromentTotalSquareMeters(enviroment)
                            )
                    );
        }
        return list;
    }

    private double getEnviromentTotalSquareMeters(Enviroment enviroment){
        return enviroment.getLength()*enviroment.getWidth();
    }

    @Override
    public void create(PropertyDTO propertyDTO) {
        District district = districtRepository.findByName(propertyDTO.getDistrictName());
        Property newProperty = mapper.map(propertyDTO,Property.class);
        newProperty.setDistrict(district);
        propertyRepository.save(newProperty);
    }

}
