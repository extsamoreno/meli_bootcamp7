package com.example.desafio1.repository;

import com.example.desafio1.exception.IDNotFoundException;
import com.example.desafio1.exception.IDPresentAllReadyException;
import com.example.desafio1.model.User;
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
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IRepository<User> {

	List<User> users;

	@PostConstruct
	@Override
	public void loadDatabase() {
		File file = null;

		try {
			file = ResourceUtils.getFile("classpath:users.json");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not find users.json.");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<User>> typeReference = new TypeReference<>() {};
		users = new ArrayList<>();

		try {
			users = objectMapper.readValue(file, typeReference);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not read from users database.");
		}
	}

	public boolean registerFollow(int userID, int userIDToFollow) throws IDNotFoundException, IDPresentAllReadyException {

		User user = users.stream().filter(u -> u.getUserID() == userID)
								  .findAny()
								  .orElse(null);

		User userToFollow = users.stream().filter(u -> u.getUserID() == userIDToFollow)
									 	  .findAny()
									 	  .orElse(null);

		if (user == null)
			throw new IDNotFoundException(userID);

		if (userToFollow == null)
			throw new IDNotFoundException(userIDToFollow);

		if (user.getFollows().contains(userIDToFollow))
			throw new IDPresentAllReadyException(userIDToFollow);

		user.getFollows().add(userIDToFollow);

		return true;
	}

	public User getFollowerCount(int userID) throws IDNotFoundException {
		User user = users.stream().filter(u -> u.getUserID() == userID)
								  .findAny()
								  .orElse(null);

		if (user == null)
			throw new IDNotFoundException(userID);

		return user;
	}

	public List<User> getFollowers(int userID) throws IDNotFoundException {
		User user = getUser(userID);

		if (user == null)
			throw new IDNotFoundException(userID);

		return users.stream().filter(u -> u.getFollows().contains(userID))
							 .collect(Collectors.toList());
	}

	public User getUser(int userID) {

		return users.stream().filter(u -> u.getUserID() == userID)
											.findAny()
											.orElse(null);
	}

	public List<User> getFollowed(Integer userID) throws IDNotFoundException {
		User user = getUser(userID);

		if (user == null)
			throw new IDNotFoundException(userID);

		return user.getFollows().stream().map(this::getUser)
										 .collect(Collectors.toList());
	}

	public boolean registerUnfollow(Integer userID, Integer userIDToUnfollow) throws IDNotFoundException, IDPresentAllReadyException {
		User user = getUser(userID);
		User userToUnfollow = getUser(userID);

		if (user == null)
			throw new IDNotFoundException(userID);

		if (userToUnfollow == null)
			throw new IDNotFoundException(userIDToUnfollow);

		if (!user.getFollows().contains(userIDToUnfollow))
			throw new IDPresentAllReadyException(userIDToUnfollow);

		user.getFollows().remove(userIDToUnfollow);

		return true;
	}
}
