package com.desafrio2.Desafio1.Model.Mapper;

import com.desafrio2.Desafio1.Model.DTO.PropDTOTMeters;
import com.desafrio2.Desafio1.Model.DTO.PropDTOTPrice;
import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IPropMapper {
    @Mapping(source = "totalMeters", target = "totalMeters")
    PropDTOTMeters toDTOMeters(PropRequest prop, double totalMeters);

    @Mapping(source = "totalPrice", target = "totalPrice")
    PropDTOTPrice toDTOPrice(PropRequest prop, double totalPrice);
}
