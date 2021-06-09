package com.example.desafio1.repository;

import com.example.desafio1.exception.PostIDAllReadyInDatabaseException;
import com.example.desafio1.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository implements IRepository<Post> {
	List<Post> posts;

	@PostConstruct
	@Override
	public void loadDatabase() {
		File file = null;

		try {
			file = ResourceUtils.getFile("classpath:posts.json");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not find posts.json.");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<Post>> typeReference = new TypeReference<>() {};
		posts = new ArrayList<>();

		try {
			posts = objectMapper.readValue(file, typeReference);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not read from users database.");
		}
	}

	public void registerNewPost(Post post) throws PostIDAllReadyInDatabaseException {
		if (posts.stream().filter(p -> p.getPostID() == post.getPostID())
						  .findAny()
						  .orElse(null) != null) {

			throw new PostIDAllReadyInDatabaseException(post.getPostID());
		}

		posts.add(post);
	}
}
