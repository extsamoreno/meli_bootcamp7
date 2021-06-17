package com.example.desafio2.service;

import com.example.desafio2.dto.*;

public interface IEstateService {

	SquareMetersDTO getEstateSquareMeters(String name);

	Double getEstateValue(String name);

	LargestEnvironmentDTO getLargestEnvironment(String name);

	EnvironmentsSquareMetersDTO getEnvironmentsSquareMeters(String name);

	void add(EstateDTO estate);
}
