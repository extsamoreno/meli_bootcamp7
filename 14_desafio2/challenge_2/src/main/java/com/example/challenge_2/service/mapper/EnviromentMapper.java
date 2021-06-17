package com.example.challenge_2.service.mapper;

import com.example.challenge_2.models.Environment;
import com.example.challenge_2.service.dto.EnvironmentDTO;
import org.springframework.stereotype.Service;

@Service
public class EnviromentMapper extends Mapper {
    public EnvironmentDTO toDTO(Environment enviroment) {
        return this.getModelMapper().map(enviroment, EnvironmentDTO.class);
    }

    public Environment toModel(EnvironmentDTO environmentDTO) {
        return this.getModelMapper().map(environmentDTO, Environment.class);
    }
}
