package com.desafio2.testing.Service;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Exception.DistrictNonExistentException;
import com.desafio2.testing.Exception.ExistentDistrictException;
import com.desafio2.testing.Exception.PropertyNonExistentException;
import com.desafio2.testing.Exception.ExistenPropertyException;
import com.desafio2.testing.Model.DistrictModel;

public interface IPropertyService {

     PropertyM2DTO calcM2PropDTO(String nombre) throws PropertyNonExistentException;
     PropertyValueDTO calcPropValueDTO(String nombre) throws PropertyNonExistentException;
     RoomDTO calcBiggestRoom(String nombre) throws PropertyNonExistentException;
     PropertyRoomListM2DTO calcRoomListM2(String nombre) throws PropertyNonExistentException;
     boolean createNewProperty(PropiedadRequestDTO propiedadRequestDTO) throws DistrictNonExistentException, ExistenPropertyException;
     DistrictModel createNewDistrict(String nombreBarrio, double precio) throws ExistentDistrictException;
     DistrictModel getDistrictByName(String name);


}
