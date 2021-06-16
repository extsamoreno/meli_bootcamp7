package com.meli.tucasitatasaciones.service.appraisal;

import com.meli.tucasitatasaciones.dto.EnvironmentDTO;
import com.meli.tucasitatasaciones.dto.ResponseDTO;

import java.util.List;

public interface IAppraisalService {
    Double getPropertyTotalSquareMeters(Integer propertyId);
    Double getPropertyValue(Integer propertyId);
    EnvironmentDTO getBiggerEnvironment(Integer propertyId);
    List<EnvironmentDTO> getEnvironmentsSquareMeters(Integer propertyId);
}
