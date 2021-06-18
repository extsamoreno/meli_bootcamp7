package com.desafio2.testing.Service;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Exception.DistrictNonExistentException;
import com.desafio2.testing.Exception.ExistenPropertyException;
import com.desafio2.testing.Exception.ExistentDistrictException;
import com.desafio2.testing.Exception.PropertyNonExistentException;
import com.desafio2.testing.Model.DistrictModel;
import com.desafio2.testing.Model.PropertyModel;
import com.desafio2.testing.Model.RoomModel;
import com.desafio2.testing.Repository.IDistrictRepository;
import com.desafio2.testing.Repository.IPropertyRepository;
import com.desafio2.testing.Service.Mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Autowired
    IDistrictRepository iDistrictRepository;


    //Calcula los M2 de una propiedad por nombre y devuelve un DTO para mostrar
    //CU0001
    public PropertyM2DTO calcM2PropDTO(String nombre) throws PropertyNonExistentException {
        double m2 = 0;

        PropertyModel property = iPropertyRepository.getPropertyByName(nombre);
        if (property == null) {
            throw new PropertyNonExistentException(nombre);
        }
        m2 = calcM2prop(property);

        return PropertyMapper.toPropiedadM2DTO(property, m2);
    }


    private double calcM2Room(RoomModel ambiente) {
        return ambiente.getEnviroment_length() * ambiente.getEnviroment_width();

    }

    //Calcula los M2 de una property
    //CU0001 y CU0002
    private double calcM2prop(PropertyModel property) {
        double m2 = 0;
        for (RoomModel a : property.getRooms()) {
            m2 += calcM2Room(a);
        }
        return m2;
    }

    //CU0002
    public PropertyValueDTO calcPropValueDTO(String name) throws PropertyNonExistentException {
        double m2 = 0, value = 0;

        PropertyModel property = iPropertyRepository.getPropertyByName(name);

        if (property == null) {
            throw new PropertyNonExistentException(name);
        }
        m2 = calcM2prop(property);
        DistrictModel district = property.getDistrict();
        value = district.getDistrict_price() * m2;

        return PropertyMapper.toPropiedadValorDTO(property, value);
    }

    //CU0003
    //Calcula el ambiente mas grande de una propiedad por nombre y retorna un ambiente DTO
    public RoomDTO calcBiggestRoom(String name) throws PropertyNonExistentException {
        PropertyModel property = iPropertyRepository.getPropertyByName(name);

        if (property == null) {
            throw new PropertyNonExistentException(name);
        }

        RoomModel maxRoom = new RoomModel();
        double maxM2 = 0, m2 = 0;

        for (RoomModel a : property.getRooms()) {
            m2 = calcM2Room(a);
            if (m2 > maxM2) {
                maxM2 = m2;
                maxRoom = a;
            }
        }
        return PropertyMapper.toAmbienteDTO(maxRoom, maxM2);
    }

    //CU0004
    public PropertyRoomListM2DTO calcRoomListM2(String name) throws PropertyNonExistentException {
        ArrayList<RoomDTO> RoomsDTOS = new ArrayList<>();
        double m2 = 0;

        PropertyModel property = iPropertyRepository.getPropertyByName(name);
        if (property == null) {
            throw new PropertyNonExistentException(name);
        }

        for (RoomModel a : property.getRooms()) {
            m2 = calcM2Room(a);
            RoomsDTOS.add(PropertyMapper.toAmbienteDTO(a, m2));
        }
        return PropertyMapper.toPropiedadListaAmbientesM2DTO(property, RoomsDTOS);
    }


    public boolean createNewProperty(PropiedadRequestDTO propiedadRequestDTO) throws DistrictNonExistentException, ExistenPropertyException {
        String districtName = propiedadRequestDTO.getDistrict_name();
        String propName = propiedadRequestDTO.getProp_name();

        if (iPropertyRepository.getPropertyByName(propName) != null) {
            throw new ExistenPropertyException(propName);
        }

        DistrictModel districtModel = getDistrictByName(districtName);
        if (districtModel == null) {
            throw new DistrictNonExistentException(districtName);
        }

        PropertyModel propModel = PropertyMapper.toPropiedadModel(propiedadRequestDTO, districtModel);
        return iPropertyRepository.addProperty(propModel);
    }


    public DistrictModel createNewDistrict(String districtName, double price) throws ExistentDistrictException {
        DistrictModel districtM = getDistrictByName(districtName);
        if (districtM != null) {
            throw new ExistentDistrictException(districtName);
        }
        DistrictModel districtModel = new DistrictModel(districtName, price);
        iDistrictRepository.addDistrict(districtModel);
        return districtModel;
    }


    public DistrictModel getDistrictByName(String name) {
        return iDistrictRepository.getDistrictByName(name);
    }


}
