package com.desafio2.demo.Model.Mapper;

import com.desafio2.demo.Model.DTO.*;
import com.desafio2.demo.Model.Environment;
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
    EnvironmentDTOResponse toEnvDTOResponse(EnvironmentDTO env);

    @Mapping(source = "prop", target = "environments", qualifiedByName = "listEnvDTO")
    PropDTOTMeterByEnvironment toPropByMeter(PropRequest prop);

    @Named("area")
    default double area(EnvironmentDTO env){
        return env.getWidth() * env.getLength();
    }

    @Named("listEnvDTO")
    default List<EnvironmentDTOResponse> listEnvDTO(PropRequest prop){
        return prop.getEnvironments().stream().map(env -> toEnvDTOResponse(env)).collect(Collectors.toList());
    }

}
