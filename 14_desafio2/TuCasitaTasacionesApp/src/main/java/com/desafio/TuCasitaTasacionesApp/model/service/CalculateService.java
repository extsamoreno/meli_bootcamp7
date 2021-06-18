package com.desafio.TuCasitaTasacionesApp.model.service;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.*;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.NeighborhoodNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.desafio.TuCasitaTasacionesApp.model.dao.repository.PropietyRepository.m2PriceForNeighborhood;

@Service
public class CalculateService implements ICalculateService {

    @Autowired
    IPropietyRepository iPropietyRepository;

    @Autowired
    ICalculateService iCalculateService;

    private ModelMapper mapper;
    public CalculateService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PropietyDTOResponseTotalMeters getSquareMeterForPropiety(String name) throws PropietyNotFoundException{
        //Auxiiliares
        double m = 0;
        //Agarro la propiedad
        Propiety propiety = iPropietyRepository.get(name);
        if(propiety == null) throw new PropietyNotFoundException(name);
        //convierto a DTO
        PropietyDTO propietyDTO = mapToDTO(propiety);

        //logica
        for(RoomDTO hab : propietyDTO.getRoomList()){
            //System.out.println("Ancho "+hab.getAncho() + "Largo" +hab.getLargo());
            m += getSquareMetersForRoom(hab);
        }
        return new PropietyDTOResponseTotalMeters(m);
    }

    @Override
    public PropietyDTOResponseCost getValueForPropiety(String name) throws PropietyNotFoundException, NeighborhoodNotFoundException {
        //Auxiliares
        double price = 0;

        //agarro la propiedad
        Propiety propiety = iPropietyRepository.get(name);
        if(propiety == null) throw new PropietyNotFoundException(name);

        //convierto a DTO
        PropietyDTO propietyDTO = mapToDTO(propiety);

        String neighborhood = propietyDTO.getNeighborhood();
        if(!m2PriceForNeighborhood.containsKey(neighborhood)) throw new NeighborhoodNotFoundException(neighborhood);
        price = m2PriceForNeighborhood.get(neighborhood);

        return  new PropietyDTOResponseCost(price*getSquareMeterForPropiety(name).getTotalMeters());
    }

    @Override
    public RoomDTO getBiggestRoom(String name) throws PropietyNotFoundException {
        //agarro la propiedad
        Propiety propiety = iPropietyRepository.get(name);
        if(propiety == null) throw new PropietyNotFoundException(name);

        //convierto a DTO
        PropietyDTO propietyDTO = mapToDTO(propiety);

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
        //Auxiliares
        double m = 0;

        //agarro la propiedad
        Propiety propiety = iPropietyRepository.get(name);
        if(propiety == null) throw new PropietyNotFoundException(name);

        //convierto a DTO
        PropietyDTO propietyDTO = mapToDTO(propiety);

        //logica
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

    /***************************************************************************/
      private PropietyDTO mapToDTO(Propiety propiety){
          PropietyDTO propietyDTO = mapper.map(propiety, PropietyDTO.class);
          return propietyDTO;
      }
    /***************************************************************************/
}

