package meli.bootcamp.tucasita.service;

import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.model.District;
import meli.bootcamp.tucasita.repository.IDistrictRepository;
import meli.bootcamp.tucasita.repository.IPropertyRepository;
import meli.bootcamp.tucasita.service.dto.*;
import meli.bootcamp.tucasita.service.mapper.DistrictDTOMapper;
import meli.bootcamp.tucasita.service.mapper.EnviromentMapper;
import meli.bootcamp.tucasita.service.mapper.PropertyDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IDistrictRepository iDistrictRepository;

    @Autowired
    IPropertyRepository propertyRepository;



    @Override
    public PropertyResponseDTO getMetersProperty(PropertyDTO property) {
        District district = iDistrictRepository.save(DistrictDTOMapper.toDistrict(property.getDistrict()));
        property.setDistrict(DistrictDTOMapper.toDTO(district));
        propertyRepository.save(PropertyDTOMapper.toProperty(property));
        double meters= property.getEnvironments().stream().mapToDouble(environment -> environment.getEnvironment_length()*environment.getEnvironment_width()
        ).sum();
        return new PropertyResponseDTO(meters,null,property);
    }

    @Override
    public PropertyResponseDTO getMetersProperty(String propertyName) throws PropertyNotFoundException {
        PropertyDTO findProperty= PropertyDTOMapper.toDTO(propertyRepository.findById(propertyName));
        double meters= findProperty.getEnvironments().stream().mapToDouble(environment -> environment.getEnvironment_length()*environment.getEnvironment_width()
                ).sum();
        return new PropertyResponseDTO(meters,null,findProperty);
    }

    @Override
    public PropertyResponseDTO getPricePropertyById(String nameProperty) throws PropertyNotFoundException {
        PropertyDTO findProperty= PropertyDTOMapper.toDTO(propertyRepository.findById(nameProperty));
        double price= findProperty.getEnvironments().stream().mapToDouble(environment -> environment.getEnvironment_length()*environment.getEnvironment_width()
                *findProperty.getDistrict().getDistrict_price()
        ).sum();
        return new PropertyResponseDTO(null,price,findProperty);
    }

    @Override
    public EnviromentResponseDTO getLargerEnvironmentPropertyById(String nameProperty) throws PropertyNotFoundException {
        PropertyDTO findProperty= PropertyDTOMapper.toDTO(propertyRepository.findById(nameProperty));
        EnvironmentDTO environmentMax = findProperty.getEnvironments().stream()
                .max(Comparator.comparing(e -> e.getEnvironment_length()*e.getEnvironment_width())).map(EnviromentMapper::toDTOSquareMetersNull).get();
        return new EnviromentResponseDTO(nameProperty,environmentMax);
    }

    @Override
    public EnviromentsMetersResponseDTO getMetersEnvironmentPropertyById(String nameProperty) throws PropertyNotFoundException {
        PropertyDTO findProperty= PropertyDTOMapper.toDTO(propertyRepository.findById(nameProperty));
        List<EnvironmentDTO> environments = findProperty.getEnvironments().stream()
                .map(EnviromentMapper::toDTO).collect(Collectors.toList());
        return new EnviromentsMetersResponseDTO(nameProperty,environments);
    }
}
