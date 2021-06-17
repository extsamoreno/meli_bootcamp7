package com.meli.testingchallenge.services;

import com.meli.testingchallenge.dtos.EnvironmentDTORes;
import com.meli.testingchallenge.dtos.EstateAssessmentDTO;
import com.meli.testingchallenge.dtos.EstateDTO;
import com.meli.testingchallenge.models.District;
import com.meli.testingchallenge.models.Environment;
import com.meli.testingchallenge.models.Estate;
import com.meli.testingchallenge.repositories.IDistrictRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private IDistrictRepository respository;

    @Override
    public EstateAssessmentDTO getAssessment(EstateDTO estateDto) {

        Estate estate = mapper.map(estateDto, Estate.class);
    System.out.println("estate.getDistrict_name() = " + estate.getDistrict_name());

        District district = respository.findDistrictByName(estate.getDistrict_name());

        return new EstateAssessmentDTO(estateDto.getProp_name(),
                calculateEstateSurface(estate.getEnvironments()),
                calculatePrice(estate, district.getPrice()),
                findBiggerEnvironment(estate.getEnvironments()),
                generateEnvironmentsCalculations(estate.getEnvironments()));
    }


    public double calculateEnvironmentSurface(Environment environment) {
        return environment.getEnvironment_length() * environment.getEnvironment_width();
    }

    public EnvironmentDTORes generateResponseDto(Environment environment) {
        return new EnvironmentDTORes(environment.getEnvironment_name(), calculateEnvironmentSurface(environment));
    }

    public double calculateEstateSurface(List<Environment> environments) {

        return environments.stream()
                .mapToDouble(e -> calculateEnvironmentSurface(e))
                .sum();
    }

    public double calculatePrice(Estate estate, Double price){

        return calculateEstateSurface(estate.getEnvironments()) * price;

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
