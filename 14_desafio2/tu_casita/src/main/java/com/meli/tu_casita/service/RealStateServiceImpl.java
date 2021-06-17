package com.meli.tu_casita.service;

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
    IRealStateDAO realStateDAO;
    @Autowired
    IDistrictDAO districtDAO;
    @Autowired
    IEnvironmentDAO environmentDAO;

    ModelMapper modelMapper = new ModelMapper();


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
        District district = districtDAO.findById(realState.getDistrictId());
        float totalPrice = 0;
        if (district != null) {
            totalPrice = totalMeters * district.getPrice();
        }//TODO: add exception
        return totalPrice;
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
        return realStateDAO.getRealStateList().stream().map(this::realStateModelToRealStateOutDTO).collect(Collectors.toList());
    }

    @Override
    public void addNewRealState(RealStateInDTO realStateInDTO) {
        if (districtDAO.findById(realStateInDTO.getDistrictId()) != null) {
            RealState realState = modelMapper.map(realStateInDTO, RealState.class);
            realStateDAO.save(realState);
            for (EnvironmentDTO environmentDTO : realStateInDTO.getEnvironments()) {
                Environment environment = modelMapper.map(environmentDTO, Environment.class);
                environment.setRealStateId(realState.getId());
                environmentDAO.save(environment);
            }
        }//TODO:add exception
    }

    private List<EnvironmentDTO> getEnvironmentDTOListFromRealStateId(int realStateId) {
        List<Environment> environmentList = environmentDAO.getEnvironmentsListByRealStateId(realStateId);
        List<EnvironmentDTO> environmentDTOList = new ArrayList<>();
        for (Environment environment : environmentList) {
            EnvironmentDTO environmentDTO = modelMapper.map(environment, EnvironmentDTO.class);
            environmentDTO.setMetersTotal(environmentDTO.getLength() * environmentDTO.getWidth());
            environmentDTOList.add(environmentDTO);
        }
        return environmentDTOList;
    }

    private RealStateOutDTO realStateModelToRealStateOutDTO(RealState model) {
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
