package com.bootcamp.desafio2.repository.house;

import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.model.House;

public interface IHouseRepository {

    House findHouseByPropName(String prop_name) throws HouseNotFoundException;
}
