package com.desafiotesting.api.service;

import com.desafiotesting.api.dto.*;
import com.desafiotesting.api.exception.NotFoundDistrictException;

import java.util.ArrayList;

public interface ITasacionesService {

    public TotalAreaDTO totalArea(PropertyDTO house);
    PriceDTO price(PropertyDTO house) throws NotFoundDistrictException;
    BiggerEnvironmentDTO biggerEnvironment(PropertyDTO house);
    ArrayList<EnvironmentAreaDTO> environmentsArea(PropertyDTO house);
    String newDistrict(DistrictDTO district) throws Exception;
}
