package com.desafio.TuCasitaTasacionesApp.model.service;


import com.desafio.TuCasitaTasacionesApp.model.dto.RoomDTO;

public interface ICalculateService {

    String getSquareMeterForPropiety(String name);

    String getValueForPropiety(String name);

    RoomDTO getBiggestRoom(String name);

    String getSquareMeterForRoom(String name);
}

