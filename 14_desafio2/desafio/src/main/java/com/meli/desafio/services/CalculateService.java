package com.meli.desafio.services;

import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.repositories.ICalculateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService{

    @Autowired
    private ICalculateRepository calculateRepository;

    @Override
    public Integer save(HouseDTO houseDTO) throws HouseAlreadyExistsException {
        return calculateRepository.save(houseDTO);
    }

    @Override
    public HouseDTO getHouseById(Integer id) throws HouseNotFoundException {
        return calculateRepository.getById(id);
    }
}
