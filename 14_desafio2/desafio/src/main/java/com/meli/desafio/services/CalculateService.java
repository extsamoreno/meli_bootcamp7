package com.meli.desafio.services;

import com.meli.desafio.models.House;
import com.meli.desafio.repositories.ICalculateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService{

    @Autowired
    private ICalculateRepository calculateRepository;

    @Override
    public Integer save(House house) {
        return calculateRepository.save(house);
    }
}
