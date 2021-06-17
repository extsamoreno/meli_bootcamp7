package com.bootcamp.tucasitatasaciones.service;

import com.bootcamp.tucasitatasaciones.DTO.PropertyDTO;
import com.bootcamp.tucasitatasaciones.DTO.TotalSquareMetersDTO;
import com.bootcamp.tucasitatasaciones.exception.NotFoundException;
import com.bootcamp.tucasitatasaciones.model.District;
import com.bootcamp.tucasitatasaciones.model.Property;
import com.bootcamp.tucasitatasaciones.repository.IDatatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IDatatRepository datatRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public void registerProperty(PropertyDTO propertyDTO) throws NotFoundException {
        District district = datatRepository.findDistrictByName(propertyDTO.getDistrict().getName());
        if (district == null) {
            throw new NotFoundException("Barrio " + propertyDTO.getDistrict().getName() + " no encontrado");
        }

        Property property = mapper.map(propertyDTO, Property.class);
        property.setDistrictId(district.getId());

        datatRepository.saveProperty(property);
    }

    @Override
    public TotalSquareMetersDTO getTotalSquareMeters(Long propertyId) throws NotFoundException {
        Property property = datatRepository.findPropertyById(propertyId);
        if (property == null) {
            throw new NotFoundException("Propiedad con id " + propertyId + " no encontrada." );
        }

        return new TotalSquareMetersDTO(property.getName(), calculateTotalSquareMeters(property));
    }

    @Override
    public List<Property> getAllProperties() {
        return datatRepository.getAllProperties();
    }

    private Double calculateTotalSquareMeters(Property property) {
        return property
                .getEnviroments()
                .stream()
                .mapToDouble(env -> env.getWidth() * env.getLength())
                .sum();
    }
}
