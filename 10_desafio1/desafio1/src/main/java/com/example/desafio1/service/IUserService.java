package com.example.desafio1.service;

import com.example.desafio1.dto.FollowedDTO;
import com.example.desafio1.dto.FollowerCountDTO;
import com.example.desafio1.dto.FollowersDTO;
import com.example.desafio1.exception.UserIDAllReadyInFollowsException;
import com.example.desafio1.exception.UserIDNotFoundException;

import java.util.List;

public interface IUserService {
	public boolean follow(int userID, int userIDToFollow) throws UserIDNotFoundException, UserIDAllReadyInFollowsException;

	public FollowerCountDTO followerCount(int id) throws UserIDNotFoundException;

	FollowersDTO followersList(Integer userID) throws UserIDNotFoundException;

	FollowedDTO followedList(Integer userID) throws UserIDNotFoundException;
}
