package com.desafio.TuCasitaTasacionesApp.model.service;


import com.desafio.TuCasitaTasacionesApp.model.dto.*;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.NeighborhoodNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyNotFoundException;

public interface ICalculateService {

    PropietyDTOResponseTotalMeters getSquareMeterForPropiety(String name) throws PropietyNotFoundException;

    PropietyDTOResponseCost getValueForPropiety(String name) throws PropietyNotFoundException, NeighborhoodNotFoundException;

    RoomDTO getBiggestRoom(String name) throws PropietyNotFoundException;

    RoomMetersListResponseDTO getSquareMeterForRoom(String name) throws PropietyNotFoundException;
}

