package com.example.desafio1.service;

import com.example.desafio1.dto.FollowedDTO;
import com.example.desafio1.dto.FollowerCountDTO;
import com.example.desafio1.dto.FollowersDTO;
import com.example.desafio1.dto.UserDTO;
import com.example.desafio1.exception.UserIDAllReadyInFollowsException;
import com.example.desafio1.exception.UserIDNotFoundException;
import com.example.desafio1.mapper.Mapper;
import com.example.desafio1.model.User;
import com.example.desafio1.repository.PostRepository;
import com.example.desafio1.repository.ProductRepository;
import com.example.desafio1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public ProductRepository productRepository;

	@Autowired
	public PostRepository postRepository;

	@Override
	public boolean follow(int userID, int userIDToFollow) throws UserIDNotFoundException, UserIDAllReadyInFollowsException {
		return userRepository.registerFollow(userID, userIDToFollow);
	}

	@Override
	public FollowerCountDTO followerCount(int userID) throws UserIDNotFoundException {
		User user = userRepository.getFollowerCount(userID);
		return Mapper.mapToUserDTO(user);
	}

	@Override
	public FollowersDTO followersList(Integer userID) throws UserIDNotFoundException {
		User user = userRepository.getUser(userID);
		List<User> users = userRepository.getFollowers(userID);

		return Mapper.mapToFollowersDTO(user, users);
	}

	@Override
	public FollowedDTO followedList(Integer userID) throws UserIDNotFoundException {
		User user = userRepository.getUser(userID);
		List<User> users = userRepository.getFollowed(userID);

		return Mapper.mapToFollowedDTO(user, users);
	}
}
