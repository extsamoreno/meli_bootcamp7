package com.example.challenge_2.service.mapper;

import com.example.challenge_2.models.Environment;
import com.example.challenge_2.service.dto.EnvironmentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EnviromentMapper {
    public static EnvironmentDTO toDTO(Environment enviroment) {
        return new ModelMapper().map(enviroment, EnvironmentDTO.class);
    }
}
