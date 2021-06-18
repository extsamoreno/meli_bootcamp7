package com.desafio2.demo.Model.Mapper;

import com.desafio2.demo.Model.DTO.*;
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

    @Mapping(source = "area", target = "totalMeter")
    EnvironmentDTOResponse toEnvDTOResponse(EnvironmentDTO env, double area);

    @Mapping(source = "prop", target = "environments", qualifiedByName = "listEnvDTO")
    PropDTOTMeterByEnvironment toPropByMeter(PropRequest prop);

    @Named("listEnvDTO")
    default List<EnvironmentDTOResponse> listEnvDTO(PropRequest prop){
        //Mappea una list EnvDTO to list EnvDTORespons
        return prop.getEnvironments().stream().map(env -> toEnvDTOResponse(env, env.area())).collect(Collectors.toList());
    }

}
