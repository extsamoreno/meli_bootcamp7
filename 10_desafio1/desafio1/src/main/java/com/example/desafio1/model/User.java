package com.example.desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	int userID;
	String userName;
	ArrayList<Integer> follows;
	boolean seller;
	ArrayList<Integer> posts;
}
