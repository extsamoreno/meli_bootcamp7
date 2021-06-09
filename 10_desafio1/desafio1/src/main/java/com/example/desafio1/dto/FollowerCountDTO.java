package com.example.desafio1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowerCountDTO {
	int userID;
	String userName;
	int followersCount;
}
