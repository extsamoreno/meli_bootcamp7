package com.example.tuCasita.services;

import com.example.tuCasita.dtos.*;
import com.example.tuCasita.exceptions.*;
import com.example.tuCasita.models.District;

import java.util.List;

public interface IHomeService {
    Double getSquareMeterByHome(Integer homeId) throws HomeIdNotFoundException;
    HomeResponseDTO insertHome(HomeDTO homeDTO) throws AlreadyExistHomeException, DistrictNotFoundException, AlreadyExistDistrictException;
    Double getPrice(Integer homeId) throws HomeIdNotFoundException;
    EnviromentDTO getBiggest(Integer homeId) throws HomeIdNotFoundException, HomeWithNoEnviromentsException;
    List<EnviromentAreasDTO> getMeterCount(Integer homeId) throws HomeIdNotFoundException;

    String insertDistrict(DistrictDTO districtDTO) throws AlreadyExistDistrictException;
}
