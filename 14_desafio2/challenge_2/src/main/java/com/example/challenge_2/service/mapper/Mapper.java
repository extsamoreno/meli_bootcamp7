package com.example.challenge_2.service.mapper;

import lombok.Getter;
import org.modelmapper.ModelMapper;

@Getter
public abstract class Mapper {
    private final ModelMapper modelMapper = new ModelMapper();
}
