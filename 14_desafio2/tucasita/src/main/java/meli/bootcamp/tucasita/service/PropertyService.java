package meli.bootcamp.tucasita.service;

import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.repository.IDistrictRepository;
import meli.bootcamp.tucasita.repository.IPropertyRepository;
import meli.bootcamp.tucasita.service.dto.PropertyDTO;
import meli.bootcamp.tucasita.service.dto.PropertyMetersResponseDTO;
import meli.bootcamp.tucasita.service.mapper.PropertyDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IDistrictRepository iDistrictRepository;

    @Autowired
    IPropertyRepository propertyRepository;


    @Override
    public PropertyMetersResponseDTO getMetersProperty(PropertyDTO property) {
        return null;
    }

    @Override
    public PropertyMetersResponseDTO getMetersProperty(String propertyName) throws PropertyNotFoundException {
        PropertyDTO findProperty= PropertyDTOMapper.toDTO(propertyRepository.findById(propertyName));
        double meters= findProperty.getEnvironments().stream().mapToDouble(environment -> environment.getEnvironment_length()*environment.getEnvironment_width()
                ).sum();
        return new PropertyMetersResponseDTO(meters,findProperty);
    }
}
