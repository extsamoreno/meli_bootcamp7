package com.example.desafio2.repository;

import com.example.desafio2.model.Estate;
import org.springframework.stereotype.Repository;

@Repository
public class EstateRepository implements IRepository<Estate> {

	@Override
	public void loadDatabase() {

	}

	@Override
	public Estate findByID(int id) {
		return null;
	}

	@Override
	public Estate findByName(String name) {
		return null;
	}
}
