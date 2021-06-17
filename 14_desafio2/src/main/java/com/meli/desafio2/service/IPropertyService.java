package com.meli.desafio2.service;

import com.meli.desafio2.dto.EnvironmentDTO;
import com.meli.desafio2.dto.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.ResponsePropTotalM2DTO;
import com.meli.desafio2.dto.ResponsePropValueDTO;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;

import java.util.List;

public interface IPropertyService {

    ResponsePropTotalM2DTO calcTotalM2(Integer propId) throws PropertyIdNotFoundException;

    ResponsePropValueDTO calcPropValue(Integer propId) throws PropertyIdNotFoundException, DistrictIdNotFoundException;

    ResponseBigEnvironmentDTO getBigEnvironment(Integer propId) throws PropertyIdNotFoundException;

    List<EnvironmentDTO> listEnvironmentsM2(Integer propId) throws PropertyIdNotFoundException;

}
