package com.desafiotesting.desafiotesting.services;
import com.desafiotesting.desafiotesting.exceptions.PropertyNotFoundException;
import com.desafiotesting.desafiotesting.models.Enviroment;
import com.desafiotesting.desafiotesting.models.Property;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentDTO;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;
import com.desafiotesting.desafiotesting.exceptions.DistrictNotFoundException;
import com.desafiotesting.desafiotesting.models.District;
import com.desafiotesting.desafiotesting.repositories.IDistrictRepository;
import com.desafiotesting.desafiotesting.repositories.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
        if(property == null){
            throw new PropertyNotFoundException("La propiedad con el id  " + id + " no existe" , HttpStatus.NOT_FOUND);
        }
        double total = 0.0;
        for (Enviroment enviroment: property.getEnviroments()
             ) {
            total += enviroment.getWidth() * enviroment.getLength();
        }
        return total;
    }

    @Override
    public double getPriceProperty(int id) {
        Property property = propertyRepository.findById(id);
        if(property == null){
            throw new PropertyNotFoundException("La propiedad con el id  " + id + " no existe" , HttpStatus.NOT_FOUND);
        }
        return totalSquareMeters(id) * property.getDistrict().getPrice();
    }

    @Override
    public EnviromentDTO getBiggerEnviroment(int id) {
        Property property = propertyRepository.findById(id);
        if(property == null){
            throw new PropertyNotFoundException("La propiedad con el id  " + id + " no existe" , HttpStatus.NOT_FOUND);
        }
        double major = 0;
        int index = 0;
        for (int i = 0; i < property.getEnviroments().size() ; i++) {
            if(major < property.getEnviroments().get(i).getLength() * property.getEnviroments().get(i).getWidth()){
                major = property.getEnviroments().get(i).getLength() * property.getEnviroments().get(i).getWidth();
                index = i;
            }
        }
        return mapper.map(
                property.getEnviroments().get(index),
                EnviromentDTO.class
        );
    }

    @Override
    public void create(PropertyDTO propertyDTO) {
        District district = districtRepository.findByName(propertyDTO.getDistrictName());
        if(district == null){
            throw new DistrictNotFoundException("El barrio " + propertyDTO.getDistrictName() + " no existe" , HttpStatus.NOT_FOUND);
        }
        Property newProperty = mapper.map(propertyDTO,Property.class);
        newProperty.setDistrict(district);
        propertyRepository.save(newProperty);
    }

}
