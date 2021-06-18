package com.meli.tu_casita.service;

import com.meli.tu_casita.exception.DistrictNotFoundException;
import com.meli.tu_casita.exception.RealStateNotFoundException;
import com.meli.tu_casita.model.District;
import com.meli.tu_casita.model.Environment;
import com.meli.tu_casita.model.RealState;
import com.meli.tu_casita.model.dto.DistrictDTO;
import com.meli.tu_casita.model.dto.EnvironmentDTO;
import com.meli.tu_casita.model.dto.RealStateInDTO;
import com.meli.tu_casita.model.dto.RealStateOutDTO;
import com.meli.tu_casita.repository.IDistrictRepository;
import com.meli.tu_casita.repository.IEnvironmentRepository;
import com.meli.tu_casita.repository.IRealStateRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RealStateServiceImpl implements IRealStateService {

    @Autowired
    private IRealStateRepository realStateRepository;
    @Autowired
    private IDistrictRepository districtRepository;
    @Autowired
    private IEnvironmentRepository environmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public float getRealStateTotalMeters(int realStateId) {
        List<Environment> environmentList = environmentRepository.getEnvironmentsListByRealStateId(realStateId);
        double totalMeters = environmentList.stream().mapToDouble(environment -> environment.getWidth() * environment.getLength()).sum();
        return (float) totalMeters;
    }

    @Override
    public float getRealStateTotalPrice(int realStateId) {
        RealState realState = realStateRepository.findById(realStateId);
        float totalMeters = this.getRealStateTotalMeters(realStateId);
        District district = districtRepository.findById(realState.getDistrictId()).get();
        return totalMeters * district.getPrice();
    }

    @Override
    public EnvironmentDTO getRealStateBiggestEnvironmentByRealStateId(int realStateId) {
        List<Environment> environmentList = environmentRepository.getEnvironmentsListByRealStateId(realStateId);
        Environment environment = environmentList.stream().max(Comparator.comparing(environmentB -> (environmentB.getWidth() * environmentB.getLength()))).get();
        return modelMapper.map(environment, EnvironmentDTO.class);
    }

    @Override
    public List<EnvironmentDTO> getEnvironmentTotalMetersListByRealStateId(int realStateId) {
        List<EnvironmentDTO> environmentList = getEnvironmentDTOListFromRealStateId(realStateId);
        environmentList.forEach(environmentDTO -> environmentDTO.setMetersTotal(environmentDTO.getLength() * environmentDTO.getWidth()));
        return environmentList;
    }

    @Override
    public List<RealStateOutDTO> getRealStateList() {
        return realStateRepository.getRealStateList().stream().map(this::MapperRealStateModelToRealStateOutDTO).collect(Collectors.toList());
    }

    @Override
    public void addNewRealState(RealStateInDTO realStateInDTO) {
        if (existsDistrict(realStateInDTO.getDistrictId())) {
            RealState realState = modelMapper.map(realStateInDTO, RealState.class);
            realStateRepository.save(realState);
            Type listType = new TypeToken<List<Environment>>() {
            }.getType();
            List<Environment> environmentList = modelMapper.map(realStateInDTO.getEnvironments(), listType);
            for (Environment environment : environmentList) {
                environment.setRealStateId(realState.getId());
                environmentRepository.save(environment);
            }
        } else {
            throw new DistrictNotFoundException(realStateInDTO.getDistrictId(), null);
        }
    }

    @Override
    public RealStateOutDTO getRealStateOutDTOByRealStateName(String name) {
        RealState realState = realStateRepository.findByName(name);
        if (realState != null) {
            return MapperRealStateModelToRealStateOutDTO(realStateRepository.findByName(name));
        } else {
            throw new RealStateNotFoundException(name, null);
        }
    }

    @Override
    public RealStateOutDTO getRealStateOutDTOByRealStateId(int id) {
        RealState realState = realStateRepository.findById(id);
        if (realState != null) {
            return MapperRealStateModelToRealStateOutDTO(realStateRepository.findById(id));
        } else {
            throw new RealStateNotFoundException(null, id);
        }
    }

    private boolean existsDistrict(int districtId) {
        return districtRepository.findById(districtId).isPresent();
    }

    private List<EnvironmentDTO> getEnvironmentDTOListFromRealStateId(int realStateId) {
        List<Environment> environmentList = environmentRepository.getEnvironmentsListByRealStateId(realStateId);
        Integer indexBiggestEnvironment = null;
        Type listType = new TypeToken<List<EnvironmentDTO>>() {
        }.getType();
        List<EnvironmentDTO> environmentDTOList = modelMapper.map(environmentList, listType);
        for (int i = 0; i < environmentDTOList.size(); i++) {
            environmentDTOList.get(i).setMetersTotal(environmentDTOList.get(i).getLength() * environmentDTOList.get(i).getWidth());
            if (indexBiggestEnvironment == null) indexBiggestEnvironment = i;
            if (environmentDTOList.get(indexBiggestEnvironment).getMetersTotal() < environmentDTOList.get(i).getMetersTotal())
                indexBiggestEnvironment = i;
        }
        if (indexBiggestEnvironment != null) {
            environmentDTOList.get(indexBiggestEnvironment).setTheBiggest(true);
        }
        return environmentDTOList;
    }

    private RealStateOutDTO MapperRealStateModelToRealStateOutDTO(RealState model) {
        RealStateOutDTO realStateOutDTO = new RealStateOutDTO();
        realStateOutDTO.setId(model.getId());
        realStateOutDTO.setName(model.getName());
        realStateOutDTO.setDistrictDTO(modelMapper.map(districtRepository.findById(model.getDistrictId()).get(), DistrictDTO.class));
        realStateOutDTO.setEnvironments(getEnvironmentDTOListFromRealStateId(model.getId()));
        realStateOutDTO.setMetersTotal(getRealStateTotalMeters(model.getId()));
        realStateOutDTO.setPrice(getRealStateTotalPrice(model.getId()));
        return realStateOutDTO;
    }

}
