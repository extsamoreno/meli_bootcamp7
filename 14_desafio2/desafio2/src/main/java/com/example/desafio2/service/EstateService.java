package com.example.desafio2.service;

import com.example.desafio2.dto.*;
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
	public SquareMetersDTO getEstateSquareMeters(String name) {
		Estate estate = estateRepository.findByName(name);
		List<Environment> environments = estate.getEnvironments().stream().map(e -> environmentRepository.findByID(e))
																		  .collect(Collectors.toList());

		double sqm = environments.stream().map(e -> e.getHeight()*e.getWidth())
										  .reduce(0.0, Double::sum);

		return Mapper.mapToDTO(sqm);
	}

	@Override
	public Double getEstateValue(String name) {
		Estate estate = estateRepository.findByName(name);
		District district = districtRepository.findByID(estate.getDistrict());
		SquareMetersDTO sqmDTO = getEstateSquareMeters(name);

		return district.getPrice()*sqmDTO.getSquareMeters();
	}

	@Override
	public LargestEnvironmentDTO getLargestEnvironment(String name) {
		Estate estate = estateRepository.findByName(name);
		Environment environment = estate.getEnvironments().stream().map(e -> environmentRepository.findByID(e))
																   .max(Comparator.comparingDouble(d -> d.getWidth()*d.getHeight()))
																   .get();

		return Mapper.mapToDTO(environment);
	}

	@Override
	public EnvironmentsSquareMetersDTO getEnvironmentsSquareMeters(String name) {
		Estate estate = estateRepository.findByName(name);
		List<Environment> environments = estate.getEnvironments().stream().map(e -> environmentRepository.findByID(e))
															 .collect(Collectors.toList());
		List<Double> prices = environments.stream().map(e -> e.getHeight()*e.getWidth())
												   .collect(Collectors.toList());

		return Mapper.mapToDTO(environments, prices);
	}

	@Override
	public void add(EstateDTO estate) {
		// Map to Estate model
		// estateRepository.add(Mapper.mapToModel(estate));
		// Map to District model
		// districtRepository.add(Mapper.mapToModel(estate.getDistrict()));
		// Map to Environmet Model
		// environmentRepository.add(estate.getEnvironments().stream().map(Mapper.mapToModel));
	}
}
