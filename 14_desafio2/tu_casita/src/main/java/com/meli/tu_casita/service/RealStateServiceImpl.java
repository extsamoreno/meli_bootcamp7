package com.meli.tu_casita.service;

import com.meli.tu_casita.exception.DistrictNotFoundException;
import com.meli.tu_casita.model.District;
import com.meli.tu_casita.model.Environment;
import com.meli.tu_casita.model.RealState;
import com.meli.tu_casita.model.dto.DistrictDTO;
import com.meli.tu_casita.model.dto.EnvironmentDTO;
import com.meli.tu_casita.model.dto.RealStateInDTO;
import com.meli.tu_casita.model.dto.RealStateOutDTO;
import com.meli.tu_casita.repository.IDistrictDAO;
import com.meli.tu_casita.repository.IEnvironmentDAO;
import com.meli.tu_casita.repository.IRealStateDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RealStateServiceImpl implements IRealStateService {

    @Autowired
    private IRealStateDAO realStateDAO;
    @Autowired
    private IDistrictDAO districtDAO;
    @Autowired
    private IEnvironmentDAO environmentDAO;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public float getRealStateTotalMeters(int realStateId) {
        RealState realState = realStateDAO.findById(realStateId);
        if (realState != null) {
            List<Environment> environmentList = environmentDAO.getEnvironmentsListByRealStateId(realStateId);
            double totalMeters = environmentList.stream().mapToDouble(environment -> environment.getWidth() * environment.getLength()).sum();
            return (float) totalMeters;
        }//TODO: add exception
        return 0;
    }

    @Override
    public float getRealStateTotalPrice(int realStateId) {
        RealState realState = realStateDAO.findById(realStateId);
        float totalMeters = this.getRealStateTotalMeters(realStateId);
        District district = districtDAO.findById(realState.getDistrictId()).get();
        return totalMeters * district.getPrice();
    }

    @Override
    public EnvironmentDTO getRealStateBiggestEnvironmentByRealStateId(int realStateId) {
        RealState realState = realStateDAO.findById(realStateId);
        if (realState != null) {
            List<Environment> environmentList = environmentDAO.getEnvironmentsListByRealStateId(realStateId);
            environmentList.stream().max(Comparator.comparing(environment -> (environment.getWidth() * environment.getLength()))).get();
        }
        return null;
    }

    @Override
    public List<EnvironmentDTO> getEnvironmentTotalMetersListByRealStateId(int realStateId) {
        RealState realState = realStateDAO.findById(realStateId);
        List<EnvironmentDTO> environmentList = new ArrayList<>();
        if (realState != null) {
            environmentList = getEnvironmentDTOListFromRealStateId(realStateId);
            environmentList.forEach(environmentDTO -> environmentDTO.setMetersTotal(environmentDTO.getLength() * environmentDTO.getWidth()));
        }//TODO: add exception
        return environmentList;
    }

    @Override
    public List<RealStateOutDTO> getRealStateList() {
        return realStateDAO.getRealStateList().stream().map(this::MapperRealStateModelToRealStateOutDTO).collect(Collectors.toList());
    }

    @Override
    public void addNewRealState(RealStateInDTO realStateInDTO) {
        if (existsDistrict(realStateInDTO.getDistrictId())) {
            RealState realState = modelMapper.map(realStateInDTO, RealState.class);
            realStateDAO.save(realState);
            for (EnvironmentDTO environmentDTO : realStateInDTO.getEnvironments()) {
                Environment environment = modelMapper.map(environmentDTO, Environment.class);
                environment.setRealStateId(realState.getId());
                environmentDAO.save(environment);
            }
        } else {
            throw new DistrictNotFoundException(realStateInDTO.getDistrictId(), null);
        }
    }

    @Override
    public RealStateOutDTO getRealStateOutDTOByRealStateName(String name) {
        return MapperRealStateModelToRealStateOutDTO(realStateDAO.findByName(name));
    }

    @Override
    public RealStateOutDTO getRealStateOutDTOByRealStateId(int id) {
        return MapperRealStateModelToRealStateOutDTO(realStateDAO.findById(id));
    }

    private boolean existsDistrict(int districtId){
        return districtDAO.findById(districtId).isPresent();
    }

    private List<EnvironmentDTO> getEnvironmentDTOListFromRealStateId(int realStateId) {
        List<Environment> environmentList = environmentDAO.getEnvironmentsListByRealStateId(realStateId);
        List<EnvironmentDTO> environmentDTOList = new ArrayList<>();
        Integer indexBiggestEnvironment = null;
        for (int i = 0 ; i < environmentList.size() ; i++ ) {
            EnvironmentDTO environmentDTO = modelMapper.map(environmentList.get(i), EnvironmentDTO.class);
            environmentDTO.setMetersTotal(environmentDTO.getLength() * environmentDTO.getWidth());
            environmentDTOList.add(environmentDTO);
            if (indexBiggestEnvironment == null) indexBiggestEnvironment = i;
            if (environmentDTOList.get(indexBiggestEnvironment).getMetersTotal() < environmentDTO.getMetersTotal()) indexBiggestEnvironment = i ;
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
        realStateOutDTO.setDistrictDTO(modelMapper.map(districtDAO.findById(model.getDistrictId()), DistrictDTO.class));
        realStateOutDTO.setEnvironments(getEnvironmentDTOListFromRealStateId(model.getId()));
        realStateOutDTO.setMetersTotal(getRealStateTotalMeters(model.getId()));
        realStateOutDTO.setPrice(getRealStateTotalPrice(model.getId()));
        return realStateOutDTO;
    }

}
