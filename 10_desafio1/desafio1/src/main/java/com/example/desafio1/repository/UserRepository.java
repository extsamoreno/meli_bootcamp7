package com.example.desafio1.repository;

import com.example.desafio1.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	public boolean registerFollow(int userID, int userIDToFollow) {
		return true;
	}

	public User getFollowerCount() {
		return new User();
	}
}
