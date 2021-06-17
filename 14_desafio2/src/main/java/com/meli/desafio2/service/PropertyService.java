package com.meli.desafio2.service;

import com.meli.desafio2.dto.EnvironmentDTO;
import com.meli.desafio2.dto.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.ResponsePropTotalM2DTO;
import com.meli.desafio2.dto.ResponsePropValueDTO;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.mappers.EnvironmentMapper;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Environment;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.repository.IDistrictRepository;
import com.meli.desafio2.repository.IPropertyRepository;
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
        List<EnvironmentDTO> listEnvM2 = listEnvironmentsM2(prop.getId());

        final Optional<EnvironmentDTO> biggestEnv = listEnvM2.stream().max((r1, r2) -> (int) (r1.getEnvM2() - r2.getEnvM2()));

        return new ResponseBigEnvironmentDTO(biggestEnv.get().getName(), biggestEnv.get().getWidth(), biggestEnv.get().getLength());

    }

    @Override
    // Get all property environments in M2
    public List<EnvironmentDTO> listEnvironmentsM2(Integer propId) throws PropertyIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        List<EnvironmentDTO> listEnvDTO = new ArrayList();

        for (Environment env : prop.getEnvironments()) {

            EnvironmentDTO envDTO = EnvironmentMapper.envToDTO(env);
            envDTO.setEnvM2(calcEnvironmentM2(env));

            listEnvDTO.add(envDTO);
        }
        return listEnvDTO;
    }

    // Calculate environment M2
    private Double calcEnvironmentM2(Environment env) {
        return env.getLength() * env.getWidth();
    }
}
