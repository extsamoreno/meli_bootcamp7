package com.meli.demo.service;

import com.meli.demo.dto.HouseDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;

public interface ITuCasitaService {

    Boolean newCasita(HouseDTO houseDTO) throws HouseExistException, PriceIncorrectException, NeighborhoodNotFounException;
}
