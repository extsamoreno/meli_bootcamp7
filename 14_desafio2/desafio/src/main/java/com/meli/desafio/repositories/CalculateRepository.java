package com.meli.desafio.repositories;

import com.meli.desafio.models.House;
import org.springframework.stereotype.Repository;

@Repository
public class CalculateRepository implements ICalculateRepository{
    @Override
    public Integer save(House house) {
        return 1;
    }
}
