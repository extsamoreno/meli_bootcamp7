package com.example.desafio2.mapper;

import com.example.desafio2.dto.*;
import com.example.desafio2.model.District;
import com.example.desafio2.model.Environment;
import com.example.desafio2.model.Estate;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

	public static EstateSquareMetersDTO mapToSquareMetersDTO(String name, double sqm) {
		return new EstateSquareMetersDTO(name, sqm);
	}

	public static LargestEnvironmentDTO mapToLargestEnvironmentDTO(Environment environment, double sqm) {
		return new LargestEnvironmentDTO(mapToEnvironmentDTO(environment), sqm);
	}

	private static EnvironmentDTO mapToEnvironmentDTO(Environment environment) {
		return new EnvironmentDTO(environment.getName(), environment.getWidth(), environment.getHeight());
	}

	public static EnvironmentSquareMetersDTO mapToEnvironmentSquareMeters(Environment environment, double sqm) {
		return new EnvironmentSquareMetersDTO(mapToEnvironmentDTO(environment), sqm);
	}

	public static District mapToDistrictModel(DistrictDTO districtDTO) {
		return new District(-1, districtDTO.getDistrict_name(), districtDTO.getDistrict_price());
	}

	public static Environment mapToEnvironmentModel(EnvironmentDTO environmentDTO) {
		return new Environment(-1, environmentDTO.getEnvironment_name(), environmentDTO.getEnvironment_width(), environmentDTO.getEnvironment_length());
	}

	public static Estate mapToEstateModel(EstateDTO estateDTO, List<District> districts, List<Environment> environments) {
		Estate estate = new Estate();

		estate.setId(-1);
		estate.setName(estateDTO.getProp_name());
		estate.setDistrict(districts.stream().filter(d -> d.getName().equals(estateDTO.getDistrict().getDistrict_name()))
											 .findAny()
											 .orElse(null).getId());
		List<Integer> envs = environments.stream().filter(e -> estateDTO.getEnvironments().stream().map(EnvironmentDTO::getEnvironment_name)
																			  					   .collect(Collectors.toList())
																			  					   .contains(e.getName()))
												  .map(Environment::getId).collect(Collectors.toList());
		estate.setEnvironments(envs);

		return estate;
	}
}
