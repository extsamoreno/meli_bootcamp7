package com.meli.testingchallenge.services;

import com.meli.testingchallenge.dtos.EnvironmentDTO;
import com.meli.testingchallenge.dtos.EstateAssessmentDTO;
import com.meli.testingchallenge.dtos.EstateDTO;
import com.meli.testingchallenge.models.Environment;
import com.meli.testingchallenge.models.Estate;
import com.meli.testingchallenge.services.mappers.EstateMappers;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateService implements IEstateService{

    @Autowired
    private ModelMapper mapper;

    @Override
    public EstateAssessmentDTO getAssessment(EstateDTO estateDto) {

        Estate estate = mapper.map(estateDto, Estate.class);
        return new EstateAssessmentDTO(estateDto.getProp_name(), estate.calculateSurface());
    }


}
