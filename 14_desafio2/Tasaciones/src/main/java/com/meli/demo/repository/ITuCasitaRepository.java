package com.meli.demo.repository;

import com.meli.demo.dto.HouseDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.HouseNotFoundException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;
import com.meli.demo.model.House;

import java.util.Set;

public interface ITuCasitaRepository {

    Boolean newCasita(House house) throws NeighborhoodNotFounException, HouseExistException, PriceIncorrectException;
    void LoadHouses();
}
