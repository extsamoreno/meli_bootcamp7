package com.meli.desafio2.service;

import com.meli.desafio2.dto.environment.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseEnvironmentDTO;
import com.meli.desafio2.dto.property.PropertyDTO;
import com.meli.desafio2.dto.property.ResponsePropTotalM2DTO;
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

    private ModelMapper mapper;

    public PropertyService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    // Calculate property total M2
    @Override
    public ResponsePropTotalM2DTO calcTotalM2(Integer propId) throws PropertyIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        double totalM2 = 0;

        for (Environment env : prop.getEnvironments()) {
            totalM2 += calcEnvironmentM2(env);
        }
        return new ResponsePropTotalM2DTO(prop.getId(), prop.getName(), totalM2);
    }

    // Calculate property value ($$)
    @Override
    public ResponsePropValueDTO calcPropValue(Integer propId) throws PropertyIdNotFoundException, DistrictIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        District dist = districtRepository.getDistrictbyId(prop.getDistrictId());

        double propValue = calcTotalM2(prop.getId()).getTotalMeters() * dist.getPrice();
        return new ResponsePropValueDTO(prop.getId(), prop.getName(), propValue);
    }

    // Returns the biggest environment of a property
    @Override
    public ResponseBigEnvironmentDTO getBigEnvironment(Integer propId) throws PropertyIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        List<ResponseEnvironmentDTO> listEnvM2 = listEnvironmentsM2(prop.getId());

        final Optional<ResponseEnvironmentDTO> biggestEnv = listEnvM2.stream().max((r1, r2) -> (int) (r1.getEnvM2() - r2.getEnvM2()));

        return new ResponseBigEnvironmentDTO(biggestEnv.get().getName(), biggestEnv.get().getWidth(), biggestEnv.get().getLength());
    }

    @Override
    // Get all property environments in M2
    public List<ResponseEnvironmentDTO> listEnvironmentsM2(Integer propId) throws PropertyIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        List<ResponseEnvironmentDTO> listEnvDTO = new ArrayList();

        for (Environment env : prop.getEnvironments()) {

            ResponseEnvironmentDTO envDTO = mapper.map(env, ResponseEnvironmentDTO.class);
            envDTO.setEnvM2(calcEnvironmentM2(env));

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

    // Calculate environment M2
    private Double calcEnvironmentM2(Environment env) {
        return env.getLength() * env.getWidth();
    }
}
