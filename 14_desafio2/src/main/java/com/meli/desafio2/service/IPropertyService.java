package com.meli.desafio2.service;

import com.meli.desafio2.dto.environment.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseEnvironmentDTO;
import com.meli.desafio2.dto.property.PropertyDTO;
import com.meli.desafio2.dto.property.ResponsePropTotalAreaDTO;
import com.meli.desafio2.dto.property.ResponsePropValueDTO;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdAlreadyExistException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;

import java.util.List;

public interface IPropertyService {

    ResponsePropTotalAreaDTO calcTotalArea(Integer propId) throws PropertyIdNotFoundException;

    ResponsePropValueDTO calcPropValue(Integer propId) throws PropertyIdNotFoundException, DistrictIdNotFoundException;

    ResponseBigEnvironmentDTO getBigEnvironment(Integer propId) throws PropertyIdNotFoundException;

    List<ResponseEnvironmentDTO> listEnvironmentsArea(Integer propId) throws PropertyIdNotFoundException;

    String createNewProperty(PropertyDTO propDTO) throws PropertyIdAlreadyExistException, DistrictIdNotFoundException;
}