package com.desafrio2.Desafio1.Model.Mapper;

import com.desafrio2.Desafio1.Model.DTO.*;
import com.desafrio2.Desafio1.Model.Environment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IPropMapper {
    @Mapping(source = "totalMeters", target = "totalMeters")
    PropDTOTMeters toDTOMeters(PropRequest prop, double totalMeters);

    @Mapping(source = "totalPrice", target = "totalPrice")
    PropDTOTPrice toDTOPrice(PropRequest prop, double totalPrice);

    @Mapping(source = "env", target = "totalMeter", qualifiedByName = "area")
    EnvironmentDTO toEnvDTO(Environment env);

    @Mapping(source = "prop", target = "environments", qualifiedByName = "listEnvDTO")
    PropDTOTMeterByEnvironment toPropByMeter(PropRequest prop);

    @Named("area")
    default double area(Environment env){
        return env.getWidth() * env.getLength();
    }

    @Named("listEnvDTO")
    default List<EnvironmentDTO> listEnvDTO(PropRequest prop){
        return prop.getEnvironments().stream().map(env -> toEnvDTO(env)).collect(Collectors.toList());
    }

}
