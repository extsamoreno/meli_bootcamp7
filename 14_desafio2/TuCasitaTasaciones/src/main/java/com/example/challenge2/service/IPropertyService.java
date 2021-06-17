package com.example.challenge2.service;

import com.example.challenge2.dtos.PriceDTO;
import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.dtos.TotalAreaDTO;
import com.example.challenge2.exceptions.NotFoundDistrictException;

public interface IPropertyService {

    public TotalAreaDTO totalArea(PropertyDTO house);
    PriceDTO price(PropertyDTO house) throws NotFoundDistrictException;
}