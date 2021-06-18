package com.example.desafio2.unit;

import com.example.desafio2.dto.EnvironmentSquareMetersDTO;
import com.example.desafio2.dto.EstateDTO;
import com.example.desafio2.dto.EstateSquareMetersDTO;
import com.example.desafio2.dto.LargestEnvironmentDTO;
import com.example.desafio2.exception.NameNotFoundException;
import com.example.desafio2.mapper.Mapper;
import com.example.desafio2.model.Estate;
import com.example.desafio2.repository.DistrictRepository;
import com.example.desafio2.repository.EnvironmentRepository;
import com.example.desafio2.repository.EstateRepository;
import com.example.desafio2.service.EstateService;
import com.example.desafio2.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstateServiceTest {

	@Mock
	EstateRepository estateRepository;

	@Mock
	DistrictRepository districtRepository;

	@Mock
	EnvironmentRepository environmentRepository;

	@InjectMocks
	EstateService estateService;

	// No se exactamente que sucede, pero no pasa el test.
	@Test
	void testAdd() {
		EstateDTO estateDTO = TestUtils.buildEstateDTO();
		Mockito.doNothing().when(districtRepository).add(Mapper.mapToDistrictModel(estateDTO.getDistrict()));
		Mockito.doNothing().when(environmentRepository).add(Mapper.mapToEnvironmentModel(estateDTO.getEnvironments().get(0)));
		Mockito.when(districtRepository.getItems()).thenReturn(TestUtils.buildDistricts());
		Mockito.when(environmentRepository.getItems()).thenReturn(TestUtils.buildEnvironments());
		Mockito.doNothing().when(estateRepository).add(Mapper.mapToEstateModel(estateDTO, districtRepository.getItems(), environmentRepository.getItems()));

		estateService.add(estateDTO);

		verify(estateService, atLeastOnce()).add(estateDTO);
	}

	@Test
	void testGetEstateSquareMeters() throws NameNotFoundException {

		Estate estate = TestUtils.buildEstate();
		Mockito.when(estateRepository.findByName("Yard")).thenReturn(estate);
		Mockito.when(environmentRepository.findByID(1)).thenReturn(TestUtils.buildEnvironment());

		EstateSquareMetersDTO received = estateService.getEstateSquareMeters("Yard");

		EstateSquareMetersDTO expected = new EstateSquareMetersDTO("Yard",50.0);

		assertEquals(expected, received);
	}

	@Test
	void testGetEstateValue() throws NameNotFoundException {

		Estate estate = TestUtils.buildEstate();
		Mockito.when(estateRepository.findByName("Asdf")).thenReturn(estate);
		Mockito.when(districtRepository.findByID(estate.getDistrict())).thenReturn(TestUtils.buildDistrict());
		Mockito.when(environmentRepository.findByID(1)).thenReturn(TestUtils.buildEnvironment());

		double received = estateService.getEstateValue("Asdf");

		double expected = 1000.0;

		assertEquals(expected, received);
	}

	@Test
	void testGetLargestEnvironment() throws NameNotFoundException {

		Estate estate = TestUtils.buildEstate();
		Mockito.when(estateRepository.findByName("Asdf")).thenReturn(estate);
		Mockito.when(environmentRepository.findByID(1)).thenReturn(TestUtils.buildEnvironment());

		LargestEnvironmentDTO received = estateService.getLargestEnvironment("Asdf");

		LargestEnvironmentDTO expected = TestUtils.buildLargestEnvironmentDTO();

		assertEquals(expected, received);
	}

	@Test
	void testGetEnvironmentsSquareMeters() throws NameNotFoundException {

		Estate estate = TestUtils.buildEstate();
		Mockito.when(estateRepository.findByName("Asdf")).thenReturn(estate);
		Mockito.when(environmentRepository.findByID(1)).thenReturn(TestUtils.buildEnvironment());

		List<EnvironmentSquareMetersDTO> received = estateService.getEnvironmentsSquareMeters("Asdf");

		List<EnvironmentSquareMetersDTO> expected = TestUtils.buildEnvironmentsSquareMeters();

		assertEquals(expected, received);
	}
}
