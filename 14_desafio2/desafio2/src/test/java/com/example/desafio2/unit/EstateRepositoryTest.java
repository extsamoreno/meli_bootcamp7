package com.example.desafio2.unit;

import com.example.desafio2.exception.IDNotFoundException;
import com.example.desafio2.exception.NameNotFoundException;
import com.example.desafio2.model.Estate;
import com.example.desafio2.repository.EstateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstateRepositoryTest {

	EstateRepository estateRepository = new EstateRepository();

	@BeforeEach()
	void loadData() {
		estateRepository.loadDatabase();
	}

	@Test
	void testLoadDatabase() {
		assertNotNull(estateRepository.getItems());
	}

	@Test
	void testFindById() throws IDNotFoundException {
		assertNotNull(estateRepository.findByID(1));
	}

	@Test
	void testFindByName() throws NameNotFoundException {
		assertNull(estateRepository.findByName(""));
	}

	@Test
	void testAdd() throws IDNotFoundException {
		Estate estate = new Estate(-1,"qwer", 5, Arrays.asList(1, 2));

		estateRepository.add(estate);

		assertNotNull(estateRepository.findByID(2));
	}

	@Test
	void testGetItems() {
		assertNotNull(estateRepository.getItems());
	}
}
