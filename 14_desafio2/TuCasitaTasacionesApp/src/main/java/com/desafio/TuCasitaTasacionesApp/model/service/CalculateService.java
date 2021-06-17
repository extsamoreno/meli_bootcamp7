package com.desafio.TuCasitaTasacionesApp.model.service;

import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {

    @Autowired
    IPropietyRepository iPropietyRepository;

    @Autowired
    ICalculateService iCalculateService;

    @Override
    public String getSquareMeterForPropiety(String name){
        return "";
    }

    @Override
    public String getValueForPropiety(String name){
        return"";
    }

    @Override
    public RoomDTO getBiggestRoom(String name){
        return null;
    }

    @Override
    public String getSquareMeterForRoom(String name){
        return"";
    }

}

