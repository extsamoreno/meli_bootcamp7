package com.example.desafio2.repository;

import com.example.desafio2.model.Estate;

public interface IRepository<T> {
	public void loadDatabase();

	T findByID(int id);

	T findByName(String name);
}
