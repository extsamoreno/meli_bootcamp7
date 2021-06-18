package com.meli.desafio2.service;

import com.meli.desafio2.dto.environment.EnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseEnvironmentDTO;
import com.meli.desafio2.dto.property.PropertyDTO;
import com.meli.desafio2.dto.property.ResponsePropTotalAreaDTO;
import com.meli.desafio2.dto.property.ResponsePropValueDTO;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdAlreadyExistException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Environment;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.repository.IDistrictRepository;
import com.meli.desafio2.repository.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    IDistrictRepository districtRepository;

    @Autowired
    ModelMapper mapper;

    // Calculate property total area (M2)
    @Override
    public ResponsePropTotalAreaDTO calcTotalArea(Integer propId) throws PropertyIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        double totalArea = 0;

        for (Environment env : prop.getEnvironments()) {
            totalArea += calcEnvironmentArea(env);
        }
        return new ResponsePropTotalAreaDTO(prop.getId(), prop.getName(), totalArea);
    }

    // Calculate property value ($$)
    @Override
    public ResponsePropValueDTO calcPropValue(Integer propId) throws PropertyIdNotFoundException, DistrictIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        District dist = districtRepository.getDistrictbyId(prop.getDistrictId());

        double propValue = calcTotalArea(prop.getId()).getTotalArea() * dist.getPrice();
        return new ResponsePropValueDTO(prop.getId(), prop.getName(), propValue);
    }

    // Returns the biggest environment of a property
    @Override
    public ResponseBigEnvironmentDTO getBigEnvironment(Integer propId) throws PropertyIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        List<ResponseEnvironmentDTO> listEnvArea = listEnvironmentsArea(prop.getId());

        final Optional<ResponseEnvironmentDTO> biggestEnv = listEnvArea.stream().max((r1, r2) -> (int) (r1.getEnvArea() - r2.getEnvArea()));

        return new ResponseBigEnvironmentDTO(biggestEnv.get().getName(), biggestEnv.get().getWidth(), biggestEnv.get().getLength());
    }

    // Get all property environments with Area
    @Override
    public List<ResponseEnvironmentDTO> listEnvironmentsArea(Integer propId) throws PropertyIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        List<ResponseEnvironmentDTO> listEnvDTO = new ArrayList();

        for (Environment env : prop.getEnvironments()) {

            ResponseEnvironmentDTO envDTO = mapper.map(env, ResponseEnvironmentDTO.class);
            envDTO.setEnvArea(calcEnvironmentArea(env));

            listEnvDTO.add(envDTO);
        }
        return listEnvDTO;
    }

    // Create a new property
    @Override
    public String createNewProperty(PropertyDTO propDTO) throws PropertyIdAlreadyExistException, DistrictIdNotFoundException {

        propertyRepository.createProperty(mapper.map(propDTO, Property.class));
        return "Property successfully created";
    }

    // Calculate environment Area (M2)
    private Double calcEnvironmentArea(Environment env) {
        return env.getLength() * env.getWidth();
    }
}
