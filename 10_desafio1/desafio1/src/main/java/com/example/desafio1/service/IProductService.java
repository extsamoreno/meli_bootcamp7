package com.example.desafio1.service;

import com.example.desafio1.dto.PostDTO;
import com.example.desafio1.exception.PostIDAllReadyInDatabaseException;
import com.example.desafio1.exception.ProductIDAllReadyInDatabaseException;

public interface IProductService {
	void newPost(PostDTO post) throws ProductIDAllReadyInDatabaseException, PostIDAllReadyInDatabaseException;
}
