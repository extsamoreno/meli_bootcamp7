package com.example.desafio1.service;

import com.example.desafio1.dto.FollowerCountDTO;
import com.example.desafio1.mapper.Mapper;
import com.example.desafio1.model.User;
import com.example.desafio1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public Mapper mapper;

	@Override
	public boolean follow(int userID, int userIDToFollow) {
		return userRepository.registerFollow(userID, userIDToFollow);
	}

	public FollowerCountDTO followerCount(int userID) {
		User user = userRepository.getFollowerCount();
		return mapper.mapToUserDTO(user);
	}
}
