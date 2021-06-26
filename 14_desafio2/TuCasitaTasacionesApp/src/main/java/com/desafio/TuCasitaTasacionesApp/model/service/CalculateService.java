package com.desafio.TuCasitaTasacionesApp.model.service;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.*;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.NeighborhoodNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.mapper.PropertyMapper;
import org.springframework.stereotype.Service;

import static com.desafio.TuCasitaTasacionesApp.model.dao.repository.PropietyRepository.m2PriceForNeighborhood;


@Service
public class CalculateService implements ICalculateService {

    private PropertyMapper mapper;

    IPropietyRepository iPropietyRepository;

    public CalculateService(IPropietyRepository iPropietyRepository, PropertyMapper modelMapper){
        this.iPropietyRepository = iPropietyRepository;
        this.mapper = modelMapper;
    }

    private PropietyDTO getPropiety(String name) throws PropietyNotFoundException {
        Propiety propiety = iPropietyRepository.get(name);
        if(propiety == null) throw new PropietyNotFoundException(name);
        PropietyDTO propietyDTO = mapper.mapToDTO(propiety);
        return propietyDTO;
    }

    @Override
    public PropietyDTOResponseTotalMeters getSquareMeterForPropiety(String name) throws PropietyNotFoundException{
        double m = 0;
        PropietyDTO propietyDTO = getPropiety(name);
        for(RoomDTO hab : propietyDTO.getRoomList()) m += getSquareMetersForRoom(hab);
        return new PropietyDTOResponseTotalMeters(m);
    }

    @Override
    public PropietyDTOResponseCost getValueForPropiety(String name) throws PropietyNotFoundException, NeighborhoodNotFoundException {
        double price = 0;
        PropietyDTO propietyDTO = getPropiety(name);
        String neighborhood = propietyDTO.getNeighborhood();
        if(!m2PriceForNeighborhood.containsKey(neighborhood)) throw new NeighborhoodNotFoundException(neighborhood);
        price = m2PriceForNeighborhood.get(neighborhood);
        return new PropietyDTOResponseCost(price*getSquareMeterForPropiety(name).getTotalMeters());
    }

    @Override
    public RoomDTO getBiggestRoom(String name) throws PropietyNotFoundException {
        PropietyDTO propietyDTO = getPropiety(name);
        RoomDTO bigRoomDTO = new RoomDTO();
        double max = 0;
        for (RoomDTO hab : propietyDTO.getRoomList()) {
            if(getSquareMetersForRoom(hab) > max){
                bigRoomDTO = hab;
                max = getSquareMetersForRoom(hab);
            }
        }
        return bigRoomDTO;
    }


    @Override
    public RoomMetersListResponseDTO getSquareMeterForRoom(String name) throws PropietyNotFoundException {
        double m = 0;
        PropietyDTO propietyDTO = getPropiety(name);
        RoomMetersListResponseDTO roomMetersListResponseDTO = new RoomMetersListResponseDTO();
        for(RoomDTO roomDTO : propietyDTO.getRoomList()){
            m = getSquareMetersForRoom(roomDTO);
            //mPorHab.put(roomDTO.getName(), m);
            roomMetersListResponseDTO.add(new RoomMetersResponseDTO(roomDTO.getName(),m));
        }
        return roomMetersListResponseDTO;
    }


    private double getSquareMetersForRoom(RoomDTO hab){
        return hab.getWidth() * hab.getLenght();
    }

    /***************************************************************************
      private PropietyDTO mapToDTO(Propiety propiety){
          PropietyDTO propietyDTO = mapper.map(propiety, PropietyDTO.class);
          return propietyDTO;
      }
    /***************************************************************************/
}

