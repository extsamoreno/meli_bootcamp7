package com.example.desafio2.service;

import com.example.desafio2.dto.*;
import com.example.desafio2.exception.NameNotFoundException;

import java.util.List;

public interface IEstateService {

	EstateSquareMetersDTO getEstateSquareMeters(String name) throws NameNotFoundException;

	Double getEstateValue(String name) throws NameNotFoundException;

	LargestEnvironmentDTO getLargestEnvironment(String name) throws NameNotFoundException;

	List<EnvironmentSquareMetersDTO> getEnvironmentsSquareMeters(String name) throws NameNotFoundException;

	void add(EstateDTO estate);
}
