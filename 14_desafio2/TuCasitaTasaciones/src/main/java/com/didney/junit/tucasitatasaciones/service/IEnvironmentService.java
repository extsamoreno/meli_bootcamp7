package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;

import java.util.List;

public interface IEnvironmentService {
    EnvironmentDTO addEnvironment(EnvironmentDTO environmentDTO);

    List<EnvironmentDTO> addEnvironments(List<EnvironmentDTO> environmentDTOList);

    List<EnvironmentDTO> getEnvironment();
}
