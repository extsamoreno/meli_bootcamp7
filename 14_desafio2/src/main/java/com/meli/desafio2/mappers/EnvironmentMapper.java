package com.meli.desafio2.mappers;

import com.meli.desafio2.dto.EnvironmentDTO;
import com.meli.desafio2.model.Environment;
import org.modelmapper.ModelMapper;

public class EnvironmentMapper {

    private static ModelMapper mapper = new ModelMapper();

    public EnvironmentMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    // EnvDTO to Env
    public static Environment toEnv(EnvironmentDTO envDTO){
        Environment env = mapper.map(envDTO, Environment.class);
        return env;
    }

    // Env to EnvDTO
    public static EnvironmentDTO envToDTO(Environment env){
        EnvironmentDTO envDTO = mapper.map(env, EnvironmentDTO.class);
        return envDTO;
    }

}
