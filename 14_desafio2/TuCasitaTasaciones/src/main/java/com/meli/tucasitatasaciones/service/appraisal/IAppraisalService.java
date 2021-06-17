package com.meli.tucasitatasaciones.service.appraisal;

import com.meli.tucasitatasaciones.dto.EnvironmentDTO;
import com.meli.tucasitatasaciones.dto.ResponseDTO;

import java.util.List;

public interface IAppraisalService {
    ResponseDTO getPropertyTotalSquareMeters(Integer propertyId);
    ResponseDTO getPropertyValue(Integer propertyId);
    ResponseDTO getBiggestEnvironment(Integer propertyId);
    ResponseDTO getEnvironmentsSquareMeters(Integer propertyId);
}
