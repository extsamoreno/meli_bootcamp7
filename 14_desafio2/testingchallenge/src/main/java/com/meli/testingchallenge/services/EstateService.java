package com.meli.testingchallenge.services;

import com.meli.testingchallenge.dtos.EnvironmentDTO;
import com.meli.testingchallenge.dtos.EnvironmentDTORes;
import com.meli.testingchallenge.dtos.EstateAssessmentDTO;
import com.meli.testingchallenge.dtos.EstateDTO;
import com.meli.testingchallenge.models.Environment;
import com.meli.testingchallenge.models.Estate;
import com.meli.testingchallenge.services.mappers.EstateMappers;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EstateService implements IEstateService{

    @Autowired
    private ModelMapper mapper;

    @Override
    public EstateAssessmentDTO getAssessment(EstateDTO estateDto) {

        Estate estate = mapper.map(estateDto, Estate.class);

        return new EstateAssessmentDTO(estateDto.getProp_name(),
                calculateEstateSurface(estate.getEnvironments()),
                calculatePrice(estate),
                findBiggerEnvironment(estate.getEnvironments()),
                generateEnvironmentsCalculations(estate.getEnvironments()));
    }


    private double calculateEnvironmentSurface(Environment environment) {
        return environment.getEnvironment_length() * environment.getEnvironment_width();
    }

    private EnvironmentDTORes generateResponseDto(Environment environment) {
        return new EnvironmentDTORes(environment.getEnvironment_name(), calculateEnvironmentSurface(environment));
    }

    private double calculateEstateSurface(List<Environment> environments) {

        return environments.stream()
                .mapToDouble(e -> calculateEnvironmentSurface(e))
                .sum();
    }

    private double calculatePrice(Estate estate){

        return calculateEstateSurface(estate.getEnvironments()) * estate.getDistrict_price();

    }

    public List<EnvironmentDTORes> generateEnvironmentsCalculations(List<Environment> environments){

        return environments.stream()
                .map(e -> generateResponseDto(e))
                .collect(Collectors.toList());
    }

    public EnvironmentDTORes findBiggerEnvironment(List<Environment> environments){
        Environment maxEnvironment;
        try{
            maxEnvironment = environments
                    .stream()
                    .max(Comparator.comparing(e -> calculateEnvironmentSurface(e)))
                    .orElseThrow(NoSuchElementException::new);
        } catch(Exception e) {
            return null;
        }
        return generateResponseDto(maxEnvironment);
    }


}
