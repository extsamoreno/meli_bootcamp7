package com.example.desafio2.utils;

import com.example.desafio2.dto.*;
import com.example.desafio2.model.District;
import com.example.desafio2.model.Environment;
import com.example.desafio2.model.Estate;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {
	public static Estate buildEstate() {
		Estate estate = new Estate();

		estate.setId(1);
		estate.setName("Asdf");
		estate.setDistrict(3);
		List<Integer> envs = new ArrayList<>();
		envs.add(1);
		estate.setEnvironments(envs);
		
		return estate;
	}
	
	public static EstateSquareMetersDTO buildEstateSquareMetersDTO() {
		EstateSquareMetersDTO sqm = new EstateSquareMetersDTO();
		
		sqm.setSquareMeters(50.0);
		sqm.setName("Asdf");
		
		return sqm;
	}

	public static LargestEnvironmentDTO buildLargestEnvironmentDTO() {
		LargestEnvironmentDTO largest = new LargestEnvironmentDTO();

		largest.setEnvironment(new EnvironmentDTO("Yard", 5.0, 10.0));
		largest.setSquareMeters(5.0*10.0);

		return largest;
	}

	public static List<EnvironmentSquareMetersDTO> buildEnvironmentsSquareMeters() {
		List<EnvironmentSquareMetersDTO> envs = new ArrayList<>();

		envs.add(new EnvironmentSquareMetersDTO(new EnvironmentDTO("Yard", 5.0, 10.0), 50.0));

		return envs;
	}

	public static Environment buildEnvironment() {
		return new Environment(1, "Yard", 5.0, 10.0);
	}

	public static District buildDistrict() {
		return new District(1, "Hell's Kitchen", 20.0);
	}

	public static EstateDTO buildEstateDTO() {
		EstateDTO estateDTO = new EstateDTO();

		estateDTO.setDistrict(buildDistrictDTO());

		List<EnvironmentDTO> envsDTO = new ArrayList<>();
		envsDTO.add(buildEnvironmentDTO());

		estateDTO.setEnvironments(envsDTO);

		return estateDTO;
	}

	private static EnvironmentDTO buildEnvironmentDTO() {
		return new EnvironmentDTO("Yard", 5.0, 10.0);
	}

	public static DistrictDTO buildDistrictDTO() {
		return new DistrictDTO("Hell's Kitchen", 20.0);
	}

	public static List<District> buildDistricts() {
		List<District> districts = new ArrayList<>();
		districts.add(buildDistrict());
		return districts;
	}

	public static List<Environment> buildEnvironments() {
		List<Environment> environments = new ArrayList<>();
		environments.add(buildEnvironment());
		return environments;
	}
}
