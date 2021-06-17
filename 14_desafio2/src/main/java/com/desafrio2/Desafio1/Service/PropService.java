package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.DTO.EnvironmentDTO;
import com.desafrio2.Desafio1.Model.DTO.PropDTOTMeters;
import com.desafrio2.Desafio1.Model.DTO.PropDTOTPrice;
import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import com.desafrio2.Desafio1.Model.District;
import com.desafrio2.Desafio1.Model.Environment;
import com.desafrio2.Desafio1.Model.Mapper.IPropMapper;
import com.desafrio2.Desafio1.Model.Prop;
import com.desafrio2.Desafio1.Repository.IPropRepository;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropService implements IPropService {

    @Autowired
    IPropRepository iPropRequestRepository;

    @Autowired
    IPropMapper propMapper;

    @Override
    public PropDTOTMeters totalSquartMeters(PropRequest prop) {
        return propMapper.toDTOMeters(prop, totalArea(prop));
    }

    @Override
    public PropDTOTPrice priceProp(PropRequest prop) throws DistrictNotExist {
        District district = iPropRequestRepository.getDistrictByName(prop.getDistrict().getName());
        double totalPrice = district.getPricePorMeter2() * totalArea(prop);
        return propMapper.toDTOPrice(prop, totalPrice);
    }

    @Override
    public Environment bigEnviroment(PropRequest prop) {
        return null;
    }

    @Override
    public List<EnvironmentDTO> meterByEnviaroment(PropRequest prop) {
        return null;
    }

    private double totalArea(PropRequest prop){
        return prop.getEnvironments().stream()
                .mapToDouble(Environment::area).sum();
    }
}