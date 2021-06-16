package com.meli.desafio2.mappers;

import com.meli.desafio2.model.Environment;
import org.modelmapper.ModelMapper;

public class EnvironmentMapper {

    private ModelMapper mapper;

    public EnvironmentMapper(ModelMapper mapper){
        this.mapper = mapper;
    }
}
