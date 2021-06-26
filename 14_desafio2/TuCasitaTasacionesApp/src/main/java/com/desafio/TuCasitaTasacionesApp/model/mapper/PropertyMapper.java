package com.desafio.TuCasitaTasacionesApp.model.mapper;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper {

    RoomMapper room;

    public PropertyMapper() {
        this.room = new RoomMapper();
    }

    public PropietyDTO mapToDTO(Propiety propiety){
        return new PropietyDTO(propiety.getName(), propiety.getNeighborhood(), this.room.mapToRoomDTOList(propiety.getRoomList()));
    }
    public Propiety mapToModel(PropietyDTO propietyDTO){
        return new Propiety(propietyDTO.getName(), propietyDTO.getNeighborhood(), this.room.mapToRoomEntityList(propietyDTO.getRoomList()));
    }
}
