package com.meli.desafio2.service;

import com.meli.desafio2.dto.ResponsePropTotalM2;
import com.meli.desafio2.exception.PropertyIdNotFoundException;

public interface IPropertyService {

    ResponsePropTotalM2 calcTotalM2(Integer propId) throws PropertyIdNotFoundException;
}
