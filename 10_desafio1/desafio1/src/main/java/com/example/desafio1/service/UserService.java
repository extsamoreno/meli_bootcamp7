package com.example.desafio1.service;

import com.example.desafio1.dto.FollowedDTO;
import com.example.desafio1.dto.FollowerCountDTO;
import com.example.desafio1.dto.FollowersDTO;
import com.example.desafio1.exception.IDNotFoundException;
import com.example.desafio1.exception.IDPresentAllReadyException;
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
	public boolean follow(int userID, int userIDToFollow) throws IDPresentAllReadyException, IDNotFoundException {
		return userRepository.registerFollow(userID, userIDToFollow);
	}

	@Override
	public FollowerCountDTO followerCount(int userID) throws IDNotFoundException {
		User user = userRepository.getFollowerCount(userID);
		return Mapper.mapToFollowerCountDTO(user);
	}

	@Override
	public FollowersDTO followersList(Integer userID) throws IDNotFoundException {
		User user = userRepository.getUser(userID);
		List<User> users = userRepository.getFollowers(userID);

		return Mapper.mapToFollowersDTO(user, users);
	}

	@Override
	public FollowedDTO followedList(Integer userID) throws IDNotFoundException {
		User user = userRepository.getUser(userID);
		List<User> users = userRepository.getFollowed(userID);

		return Mapper.mapToFollowedDTO(user, users);
	}

	@Override
	public boolean unfollow(Integer userID, Integer userIDToUnfollow) throws IDNotFoundException, IDPresentAllReadyException {
		return userRepository.registerUnfollow(userID, userIDToUnfollow);
	}
}
