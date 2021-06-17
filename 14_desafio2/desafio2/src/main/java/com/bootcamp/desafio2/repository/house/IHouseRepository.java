package com.bootcamp.desafio2.repository.house;

import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.entity.House;

public interface IHouseRepository {

    boolean existsPropertyName(String prop_name);

    House findHouseByPropName(String prop_name) throws HouseNotFoundException;

    void saveNewProperty(House house);
}
