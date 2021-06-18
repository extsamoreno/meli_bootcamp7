package com.example.desafio2.service;

import com.example.desafio2.dto.*;
import com.example.desafio2.exception.NameNotFoundException;
import com.example.desafio2.mapper.Mapper;
import com.example.desafio2.model.District;
import com.example.desafio2.model.Environment;
import com.example.desafio2.model.Estate;
import com.example.desafio2.repository.DistrictRepository;
import com.example.desafio2.repository.EnvironmentRepository;
import com.example.desafio2.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstateService implements IEstateService {

	@Autowired
	EstateRepository estateRepository;

	@Autowired
	EnvironmentRepository environmentRepository;

	@Autowired
	DistrictRepository districtRepository;

	@Override
	public void add(EstateDTO estateDTO) {
		districtRepository.add(Mapper.mapToDistrictModel(estateDTO.getDistrict()));

		estateDTO.getEnvironments().forEach(e -> environmentRepository.add(Mapper.mapToEnvironmentModel(e)));

		estateRepository.add(Mapper.mapToEstateModel(estateDTO, districtRepository.getItems(), environmentRepository.getItems()));
	}

	@Override
	public EstateSquareMetersDTO getEstateSquareMeters(String name) throws NameNotFoundException {
		Estate estate = estateRepository.findByName(name);

		List<Environment> environments = estate.getEnvironments().stream().map(e -> environmentRepository.findByID(e))
																		  .collect(Collectors.toList());

		double sqm = environments.stream().map(e -> e.getHeight()*e.getWidth())
										  .reduce(0.0, Double::sum);

		return Mapper.mapToSquareMetersDTO(name, sqm);
	}

	@Override
	public Double getEstateValue(String name) throws NameNotFoundException {
		Estate estate = estateRepository.findByName(name);
		District district = districtRepository.findByID(estate.getDistrict());
		EstateSquareMetersDTO sqmDTO = getEstateSquareMeters(name);

		return district.getPrice()*sqmDTO.getSquareMeters();
	}

	@Override
	public LargestEnvironmentDTO getLargestEnvironment(String name) throws NameNotFoundException {
		Estate estate = estateRepository.findByName(name);
		Environment environment = estate.getEnvironments().stream().map(e -> environmentRepository.findByID(e))
																   .max(Comparator.comparingDouble(d -> d.getWidth()*d.getHeight()))
																   .get();

		return Mapper.mapToLargestEnvironmentDTO(environment, environment.getWidth()*environment.getHeight());
	}

	@Override
	public List<EnvironmentSquareMetersDTO> getEnvironmentsSquareMeters(String name) throws NameNotFoundException {
		Estate estate = estateRepository.findByName(name);
		List<Environment> environments = estate.getEnvironments().stream().map(e -> environmentRepository.findByID(e))
															 			  .collect(Collectors.toList());

		return environments.stream().map(e -> Mapper.mapToEnvironmentSquareMeters(e, e.getHeight()*e.getWidth()))
									.collect(Collectors.toList());
	}
}
