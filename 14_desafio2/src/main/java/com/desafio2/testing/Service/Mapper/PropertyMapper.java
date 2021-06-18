package com.desafio2.testing.Service.Mapper;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Model.RoomModel;
import com.desafio2.testing.Model.DistrictModel;
import com.desafio2.testing.Model.PropertyModel;

import java.util.ArrayList;

public class PropertyMapper {

    public static PropertyM2DTO toPropiedadM2DTO(PropertyModel propiedad, double m2){
       return new PropertyM2DTO(propiedad.getProp_name(), m2);
    }


    public static PropertyValueDTO toPropiedadValorDTO (PropertyModel propiedad, double valor){
        return new PropertyValueDTO(propiedad.getProp_name(), valor);
    }

    public static RoomDTO toAmbienteDTO (RoomModel ambiente, double m2){
        return new RoomDTO(ambiente.getEnviroment_name(), m2);
    }


    public static PropertyRoomListM2DTO toPropiedadListaAmbientesM2DTO(PropertyModel propiedad, ArrayList<RoomDTO> ambientes){
        return new PropertyRoomListM2DTO(propiedad.getProp_name(),ambientes);
    }

    public static RoomModel toAmbienteModel (RoomRequestDTO ambiente){
      return new RoomModel(ambiente.getEnviroment_name(),ambiente.getEnviroment_width(), ambiente.getEnviroment_length());
    }

    public static PropertyModel toPropiedadModel (PropiedadRequestDTO propiedad, DistrictModel barrio){
       ArrayList<RoomModel> ambientesM= new ArrayList<>();
       PropertyModel propertyModel = new PropertyModel();

        for (RoomRequestDTO a: propiedad.getRooms()) {
            ambientesM.add(toAmbienteModel(a));
        }
        propertyModel.setProp_name(propiedad.getProp_name());
        propertyModel.setDistrict(barrio);
        propertyModel.setRooms(ambientesM);
        propertyModel.setCantRooms(ambientesM.size());

        return propertyModel;
    }


}
