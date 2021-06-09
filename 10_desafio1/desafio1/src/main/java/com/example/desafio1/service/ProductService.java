package com.example.desafio1.service;

import com.example.desafio1.dto.PostDTO;
import com.example.desafio1.exception.PostIDAllReadyInDatabaseException;
import com.example.desafio1.exception.ProductIDAllReadyInDatabaseException;
import com.example.desafio1.mapper.Mapper;
import com.example.desafio1.repository.PostRepository;
import com.example.desafio1.repository.ProductRepository;
import com.example.desafio1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public ProductRepository productRepository;

	@Autowired
	public PostRepository postRepository;

	@Override
	public void newPost(PostDTO post) throws ProductIDAllReadyInDatabaseException, PostIDAllReadyInDatabaseException {
		productRepository.registerProduct(Mapper.mapToProductModel(post.getDetail()));
		postRepository.registerNewPost(Mapper.mapToPostModel(post));
	}
}
