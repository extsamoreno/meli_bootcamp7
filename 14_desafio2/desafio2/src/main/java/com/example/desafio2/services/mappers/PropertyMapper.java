package com.example.desafio2.services.mappers;

import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.models.Property;
import com.example.desafio2.repositories.DistrictRepository;
import com.example.desafio2.repositories.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertyMapper {

    public static Property toModel(PropertyDTO prop){

        Property modelProp = new Property();

        modelProp.setName(prop.getName());
        modelProp.setRoomList(RoomMapper.toModelList(prop.getRoomList()));
        modelProp.setDistrictId(prop.getDistrictId());

        return modelProp;
    }
}
