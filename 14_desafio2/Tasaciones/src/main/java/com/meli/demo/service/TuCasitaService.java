package com.meli.demo.service;


import com.meli.demo.dto.HouseDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;
import com.meli.demo.repository.ITuCasitaRepository;
import com.meli.demo.service.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuCasitaService implements ITuCasitaService{

    @Autowired
    ITuCasitaRepository iTuCasitaRepository;



    @Override
    public Boolean newCasita(HouseDTO houseDTO) throws HouseExistException, PriceIncorrectException, NeighborhoodNotFounException {
        return iTuCasitaRepository.newCasita(HouseMapper.toHouse(houseDTO));
    }
}
