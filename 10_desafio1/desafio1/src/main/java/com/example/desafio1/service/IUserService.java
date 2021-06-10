package com.example.desafio1.service;

import com.example.desafio1.dto.FollowedDTO;
import com.example.desafio1.dto.FollowerCountDTO;
import com.example.desafio1.dto.FollowersDTO;
import com.example.desafio1.exception.IDNotFoundException;
import com.example.desafio1.exception.IDPresentAllReadyException;

public interface IUserService {
	public boolean follow(int userID, int userIDToFollow) throws IDPresentAllReadyException, IDNotFoundException;

	public FollowerCountDTO followerCount(int id) throws IDNotFoundException;

	FollowersDTO followersList(Integer userID) throws IDNotFoundException;

	FollowedDTO followedList(Integer userID) throws IDNotFoundException;

	boolean unfollow(Integer userID, Integer userIDToUnfollow) throws IDNotFoundException, IDPresentAllReadyException;
}
