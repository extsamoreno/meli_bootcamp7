package com.desafio2.testing.Service.Mapper;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Model.RoomModel;
import com.desafio2.testing.Model.DistrictModel;
import com.desafio2.testing.Model.PropertyModel;

import java.util.ArrayList;

public interface IPropertyMapper {
      PropertyM2DTO toPropiedadM2DTO(PropertyModel property, double m2);
      PropertyValueDTO toPropiedadValorDTO (PropertyModel property, double valor);
      RoomDTO toAmbienteDTO (RoomModel room, double m2);
      PropertyRoomListM2DTO toPropiedadListaAmbientesM2DTO(PropertyModel property, ArrayList<RoomDTO> rooms);
      RoomModel toAmbienteModel (RoomRequestDTO room);
      PropertyModel toPropiedadModel (PropiedadRequestDTO property, DistrictModel district);


}
