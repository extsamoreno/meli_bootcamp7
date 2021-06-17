package com.meli.desafio2.service;

import com.meli.desafio2.dto.*;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdAlreadyExistException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;

import java.util.List;

public interface IPropertyService {

    ResponsePropTotalM2DTO calcTotalM2(Integer propId) throws PropertyIdNotFoundException;

    ResponsePropValueDTO calcPropValue(Integer propId) throws PropertyIdNotFoundException, DistrictIdNotFoundException;

    ResponseBigEnvironmentDTO getBigEnvironment(Integer propId) throws PropertyIdNotFoundException;

    List<EnvironmentDTO> listEnvironmentsM2(Integer propId) throws PropertyIdNotFoundException;

    String createNewProperty(PropertyDTO propDTO) throws PropertyIdAlreadyExistException, DistrictIdNotFoundException;
}
