package com.meli.tuCasita.service;

import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.AmbientDTO;
import com.meli.tuCasita.model.HouseDTO;

import java.util.HashMap;

public interface IHouseService {
    HouseDTO getDistricto(HouseDTO houseDTO) throws HouseNotFoundException;
    HashMap<String, Double> getmaxambientforambient(Long id, String nameAmbient) throws  HouseNotFoundException;
    AmbientDTO getMaxAmbient(Long id) throws  HouseNotFoundException;
    Double getMeter2(Long id) throws  HouseNotFoundException;
    Double getPrice(Long id) throws  HouseNotFoundException;
    boolean create(HouseDTO stu) throws  HouseNotFoundException;
    HouseDTO read(Long id) throws  HouseNotFoundException;
}
