package com.example.desafio2.repository;

import com.example.desafio2.model.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class EnvironmentRepository implements IRepository<Environment> {

	@Override
	public void loadDatabase() {

	}

	@Override
	public Environment findByID(int id) {
		return null;
	}

	@Override
	public Environment findByName(String name) {
		return null;
	}
}
