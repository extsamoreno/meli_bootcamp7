package com.example.desafio1.mapper;

import com.example.desafio1.dto.FollowerCountDTO;
import com.example.desafio1.model.User;

public class Mapper {

	public static FollowerCountDTO mapToUserDTO(User user) {
		return new FollowerCountDTO();
	}
}
