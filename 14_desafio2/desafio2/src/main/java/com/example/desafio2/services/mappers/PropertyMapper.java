package com.example.desafio2.services.mappers;

import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.models.Property;

public class PropertyMapper {
    public static Property toModel(PropertyDTO prop){
        Property modelProp = new Property();

        modelProp.setName(prop.getName());
        modelProp.setRoomList(RoomMapper.toModelList(prop.getRoomList()));
        modelProp.setDistrict(DistrictMapper.toModel(prop.getDistrict()));

        return modelProp;
    }
}
