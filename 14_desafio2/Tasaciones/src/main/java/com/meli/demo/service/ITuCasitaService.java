package com.meli.demo.service;

import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.HouseDTO;
import com.meli.demo.dto.response.EnvironmentsTotalDTO;
import com.meli.demo.dto.response.PriceMetersResponseDTO;
import com.meli.demo.dto.response.TotalMetersResponseDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.HouseNotFoundException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;

import java.util.HashMap;

public interface ITuCasitaService {

    Boolean newCasita(HouseDTO houseDTO) throws HouseExistException, PriceIncorrectException, NeighborhoodNotFounException;
    TotalMetersResponseDTO totalMeters(String nameHouse) throws HouseNotFoundException;
    PriceMetersResponseDTO priceMeters(String nameHouse) throws HouseNotFoundException;
    EnvironmentDTO biggerEnvironment (String nameHouse) throws HouseNotFoundException;
    EnvironmentsTotalDTO totalMetersByEnvironment(String nameHouse) throws HouseNotFoundException;
    HouseDTO  viewHouse(String nameHouse)throws HouseNotFoundException;
    HashMap<String, Double> viewNeighborhoods();
}
