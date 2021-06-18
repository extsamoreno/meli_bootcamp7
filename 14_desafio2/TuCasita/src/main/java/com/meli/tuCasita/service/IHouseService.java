package com.meli.tuCasita.service;

import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.Ambient;
import com.meli.tuCasita.model.House;
import com.meli.tuCasita.service.dto.ResponseGetPriceDTO;
import com.meli.tuCasita.service.dto.ResponseMeter2DTO;

import java.util.HashMap;

public interface IHouseService {
    House getDistricto(House house) throws HouseNotFoundException;
    HashMap<String, Double> getmaxambientforambient(Long id, String nameAmbient) throws  HouseNotFoundException;
    Ambient getMaxAmbient(Long id) throws  HouseNotFoundException;
    ResponseMeter2DTO getMeter2(Long id) throws  HouseNotFoundException;
    ResponseGetPriceDTO getPrice(Long id) throws  HouseNotFoundException;
    boolean create(House stu) throws  HouseNotFoundException;
    House read(Long id) throws  HouseNotFoundException;
}
